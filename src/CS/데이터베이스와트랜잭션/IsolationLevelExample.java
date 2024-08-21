package CS.데이터베이스와트랜잭션;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsolationLevelExample {

    public static void main(String[] args) throws InterruptedException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        Thread t1 = new Thread(() -> {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                // 트랜잭션 시작
                conn.setAutoCommit(false);

                // READ COMMITTED 격리 수준 설정
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

                // 첫 번째 읽기
                String query = "SELECT balance FROM accounts WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, 1); // id가 1인 계정 조회
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Thread 1 - First Read: " + rs.getDouble("balance"));
                }

                // 인위적으로 지연
                Thread.sleep(2000);

                // 두 번째 읽기
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Thread 1 - Second Read: " + rs.getDouble("balance"));
                }

                // 트랜잭션 커밋
                conn.commit();

            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                // 트랜잭션 시작
                conn.setAutoCommit(false);

                // READ COMMITTED 격리 수준 설정
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

                // 계정 잔액 업데이트
                String updateQuery = "UPDATE accounts SET balance = balance + 100 WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                pstmt.setInt(1, 1);
                pstmt.executeUpdate();

                System.out.println("Thread 2 - Updated Balance");

                // 트랜잭션 커밋
                conn.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        // t1이 첫 번째 읽기를 수행한 후 t2가 실행되도록 대기
        Thread.sleep(1000);
        t2.start();

        t1.join();
        t2.join();
    }
}
