/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Repository로부터 유저 데이터를 받아 요청을 처리하여 반환
 *
 * @author 강대한
 */
public class PostRepository {

    private static PostRepository postRepository_ = new PostRepository();
    private static Repository repository_ = Repository.repository();

    private PostRepository() {
    }

    public static PostRepository postRepository() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
        return postRepository_;
    }

    public void create(JSONObject jsonObj) {
        JSONArray jsonArr = repository_.get("postFile");
        jsonArr.add(jsonObj);
        repository_.set("postFile", jsonArr);
    }

    public void update(JSONArray jsonArr) {
        repository_.set("postFile", jsonArr);
    }

    public JSONArray getPostArray() {
        return repository_.get("postFile");
    }

    public int findIndex(String title, String user, String time) {
        JSONArray jsonArr = repository_.get("postFile");
        int index = 0;
        for (Object obj : jsonArr) { //삭제된 글을 뺀 글 리스트를 새롭게 만든다. 
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("Title").equals(title) && jsonObj.get("User").equals(user)) { //글 정보 확인
                List<String> timeList = new ArrayList<String>();
                timeList = (List<String>) jsonObj.get("TimeList");
                int latestIndex = timeList.size() - 1;
                if (timeList.get(latestIndex).equals(time)) {
                    break;
                }
            }
            index++;
        }
        return index;
    }
    
    public List<Integer> findUserPostIndex(String user) {
        JSONArray jsonArr = repository_.get("postFile");
        int index = 0;
        List<Integer> indexList = new ArrayList<Integer>();
        for (Object obj : jsonArr) { //삭제된 글을 뺀 글 리스트를 새롭게 만든다. 
            JSONObject jsonObj = (JSONObject) obj;
            if (jsonObj.get("User").equals(user)) { //글 정보 확인
                indexList.add(index);              
            }
            index++;
        }
        return indexList;
    }
}