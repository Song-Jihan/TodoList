package todoList;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class TodoListService {
  static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  static TodoListRepository todoListRepository=new TodoListRepository();

  static Long todoId=0L;
  static Long categoryId=0L;

  public Long returnTodoId(String whatTodo) throws IOException{
    findCompletedTodoList();
    System.out.print(whatTodo+" 할 일 번호 입력: ");
    return todoId=Long.parseLong(br.readLine());
  }

  public Long returnCategoryId(String whatTodo) throws IOException{
    findAllCategory();
    System.out.print(whatTodo+" 카테고리 번호 입력: ");
    return categoryId=Long.parseLong(br.readLine());
  }

  public void findAllCategory(){
    ArrayList<TodoCategoryDTO> categoryList=todoListRepository.findAllCategory();
    for(TodoCategoryDTO category:categoryList){
      System.out.println(category);
    }
  }

  private boolean categoryDuplicationCheck(String categoryName){
    if(todoListRepository.categoryDuplicationCheck(categoryName)){
      System.out.println("유효한 카테고리");
      return true;
    }
    System.out.println("카테고리 없음");
    return false;
  }
  
  public void findIncompletedTodoList(){
    ArrayList<TodoListDTO> incompletedList=todoListRepository.findIncompletedTodoList();
    if(incompletedList.isEmpty()){
      printEmptyList();
    }
    else{
      for(TodoListDTO todo:incompletedList){
        System.out.println(todo);
      }
    }
  }

  public void findCompletedTodoList(){
    ArrayList<TodoListDTO> completedList=todoListRepository.findCompletedTodoList();
    if(completedList.isEmpty()){
      printEmptyList();
    }
    else{
      for(TodoListDTO todo:completedList){
        System.out.println(todo);
      }
    }
  }

  public void findTodoListByCategory() throws IOException{
    Long categoryId=returnCategoryId("찾음");
    String categoryName=todoListRepository.findCategoryNameByCategoryId(categoryId);
    if(categoryName==null){
      TodoListMain.PrintWrongNum();
    }
    else{
      ArrayList<TodoListDTO> todoListByCategory=todoListRepository.findTodoListByCategory(categoryName);
      if(todoListByCategory.isEmpty()){
        printEmptyList();
      }
      else{
        for(TodoListDTO todo:todoListByCategory){
          System.out.println(todo);
        }
      }
    }
  }

  public void findTodoListByKeyword() throws IOException{
    System.out.print("키워드 입력: ");
    String keyword=br.readLine();
    ArrayList<TodoListDTO> todoListByKeyword=todoListRepository.findTodoListByKeyword(keyword);
    if(todoListByKeyword.isEmpty()){
      printEmptyList();
    }
    else{
      for(TodoListDTO todo:todoListByKeyword){
        System.out.println(todo);
      }
    }
  }

  public void defaultCategorySave(){
    TodoCategoryDTO newCategory=new TodoCategoryDTO(++categoryId, "내 할 일 목록", "기본 내 할 일");
    todoListRepository.saveCategory(newCategory);
    newCategory=new TodoCategoryDTO(++categoryId,"완료한 할 일 목록","완료한 할 일 목록");
    todoListRepository.saveCategory(newCategory);
  }

  public void saveTodo() throws IOException{
    System.out.print("새로 할 일 내용 입력: ");
    String todoContent=br.readLine();
    Long categoryId=returnCategoryId("찾음");
    String categoryName=todoListRepository.findCategoryNameByCategoryId(categoryId);
    if(categoryName==null){
      TodoListMain.PrintWrongNum();
    }
    else{
      System.out.print("마감일 입력(YYYY.MM.DD): ");
      String todoDeadline=br.readLine();
      SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.DD");
      String todoCreateDate = sdf.format(Calendar.getInstance().getTime());
      TodoListDTO newTodo=new TodoListDTO(++todoId, todoContent, categoryName, todoDeadline, todoCreateDate);
      if(todoListRepository.saveTodo(newTodo)){
        System.out.println("할 일 등록 완료");
      }
      else{
        System.out.println("할 일 등록 실패");
      }
    }  
  }

  public void saveCategory() throws IOException{
    System.out.print("새 카테고리 이름 입력: ");
    String categoryName=br.readLine();
    if(categoryDuplicationCheck(categoryName)){
      System.out.println("카테고리 이름 중복");
    }
    else{
      System.out.print("새 카테고리 설명 입력:");
      String categoryDiscription=br.readLine();
      TodoCategoryDTO newCategory=new TodoCategoryDTO(++categoryId,categoryName,categoryDiscription);
      if(todoListRepository.saveCategory(newCategory)){
        System.out.println("카테고리 저장 성공");
      }
      else{
        System.out.println("카테고리 저장 실패");
      }
      findAllCategory();
    }
  }

  private void printEmptyList(){
    System.out.println("목록이 존재하지 않음");
  }
  
}