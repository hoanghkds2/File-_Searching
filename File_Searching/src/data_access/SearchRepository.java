package repository;

import dataAccess.SearchDAO;


public class SearchRepository implements ISearch {
    @Override
    public void countWordInFile(String path, String word){
        System.out.println("Count: " + SearchDAO.Instance().countWordInFile(path, word));
    }
    
    @Override
    public void getFileNameContainsWordInDirectory(String path, String word){
        SearchDAO.Instance().getFileNameContainsWordInDirectory(path, word);
    }
}
