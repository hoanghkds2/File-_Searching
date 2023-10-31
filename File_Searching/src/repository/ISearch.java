package repository;

public interface ISearch {

    void countWordInFile(String path, String word);

    void getFileNameContainsWordInDirectory(String path, String word);

}
