import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CreateZipAndDownload {
    final static String folder = "D:/zip_test_folder";
    public static void main(String[] args) {
        File file1 = new File(folder, "1.txt");
        File file2 = new File(folder, "2.txt");

        List<File> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);

        File zipFile = new File(folder, "압축파일.zip");
        byte[] buf = new byte[4096];

        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile))){

            for(File file : files){
                try(FileInputStream in = new FileInputStream(file)){
                    ZipEntry ze = new ZipEntry(file.getName());
                    out.putNextEntry(ze);

                    int len;
                    while((len = in.read(buf)) > 0){
                        out.write(buf, 0, len);
                    }

                    out.closeEntry();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("zipSuccess");
        }
    }
}
