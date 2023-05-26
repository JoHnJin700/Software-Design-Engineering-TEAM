/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Model.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 전반적인 데이터 입출력을 수행하는 FileManager
 *
 * @author 강대한
 */
public class FileManager {

    private static String file;
    private static String postFile = "src\\main\\java\\deu\\cse\\blog\\Data\\post.json"; // 작성된 글 데이터
    private static String userFile = "src\\main\\java\\deu\\cse\\blog\\Data\\user.json"; // 유저 데이터
    private static String commentFile = "src\\main\\java\\deu\\cse\\blog\\Data\\comment.json"; // 댓글 데이터
    private static FileManager fileManager_ = new FileManager();

    private FileManager() {
    }

    public static FileManager fileManager() { //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 생성자를 private으로 해두고 객체를 이른 초기화로 생성, 정적 메서드를 통해 객체 반환
        return fileManager_;
    }

    public static JSONArray get(String fileType) throws IOException, ParseException {
        // 어떤 파일에 접근할지 결정
        if (fileType.equals("postFile")) {
            file = postFile;
        } else if (fileType.equals("commentFile")) {
            file = commentFile;
        } else if (fileType.equals("userFile")) {
            file = userFile;
        }

        Object obj = new Object();
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = new JSONArray();
        try {
            FileReader reader = new FileReader(file, Charset.forName("utf-8"));
            obj = parser.parse(reader);
            jsonArr = (JSONArray) obj;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArr;
    }

    public static void set(String fileType, JSONArray jsonArr) throws IOException, ParseException {
        // 어떤 파일에 접근할지 결정
        if (fileType.equals("postFile")) {
            file = postFile;
        } else if (fileType.equals("commentFile")) {
            file = commentFile;
        } else if (fileType.equals("userFile")) {
            file = userFile;
        }
        
        try {
            FileWriter writer = new FileWriter(file, Charset.forName("utf-8"));
            writer.write(jsonArr.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
