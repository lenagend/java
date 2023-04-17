package 알고리즘;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution4 {
    public static void main(String[] args) {
        String[][] folders1 = {{"animal", "root"}, {"fruit", "root"}};
        String[][] files1 = {{"cat", "1B", "animal"}, {"dog", "2B", "animal"}, {"apple", "4B", "fruit"}};
        String[] selected1 = {"animal"};
        String[] excepted1 = {"apple"};
        System.out.println(Arrays.toString(solution(folders1, files1, selected1, excepted1))); // Output: [3, 2]

        String[][] folders2 = {{"food", "root"}, {"meat", "food"}, {"fruit", "food"}, {"animal", "root"}};
        String[][] files2 = {{"cat", "1B", "animal"}, {"dog", "2B", "animal"}, {"fork", "1KB", "meat"},
                {"beef", "8KB", "meat"}, {"apple", "4B", "fruit"}, {"fire", "83B", "root"}};
        String[] selected2 = {"root", "meat"};
        String[] excepted2 = {"fork", "apple"};
        System.out.println(Arrays.toString(solution(folders2, files2, selected2, excepted2))); // Output: [8278, 4]
    }

    public static int[] solution(String[][] folders, String[][] files, String[] selected, String[] excepted) {
        Map<String, List<String>> folderMap = new HashMap<>();
        Map<String, String> fileMap = new HashMap<>();
        Set<String> exceptedSet = new HashSet<>(Arrays.asList(excepted));
        Set<String> selectedSet = new HashSet<>(Arrays.asList(selected));

        for (String[] folder : folders) {
            folderMap.computeIfAbsent(folder[1], k -> new ArrayList<>()).add(folder[0]);
        }

        for (String[] file : files) {
            fileMap.put(file[0], file[1] + "_" + file[2]);
        }

        int totalSize = 0;
        int fileCount = 0;

        Set<String> allSelectedFolders = new HashSet<>();

        for (String sel : selectedSet) {
            allSelectedFolders.add(sel);
            getAllChildrenFolders(folderMap, sel, allSelectedFolders);
        }

        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            String fileName = entry.getKey();
            String[] fileInfo = entry.getValue().split("_");
            String fileSize = fileInfo[0];
            String fileFolder = fileInfo[1];

            if (!exceptedSet.contains(fileName) && allSelectedFolders.contains(fileFolder)) {
                fileCount++;
                totalSize += convertSizeToBytes(fileSize);
            }
        }
        int[] answer = {totalSize, fileCount};

        return answer;
    }

    private static int convertSizeToBytes(String size) {
        return Integer.parseInt(size.replaceAll("\\D", "")) * (size.endsWith("KB") ? 1024 : 1);
    }

    private static void getAllChildrenFolders(Map<String, List<String>> folderMap, String parent, Set<String> allSelectedFolders) {
        List<String> children = folderMap.get(parent);
        if (children == null) {
            return;
        }

        for (String child : children) {
            allSelectedFolders.add(child);
            getAllChildrenFolders(folderMap, child, allSelectedFolders);
        }
    }
}
