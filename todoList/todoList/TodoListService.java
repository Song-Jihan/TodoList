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

  Long todoListId=0L;
  Long categoryListId=0L;

  public Long returnTodoId(String whatTodo) throws IOException{
    if(!findIncompletedTodoList()){
      return 0L;
    }
    System.out.print(whatTodo+" 할 일 번호 입력: ");
    return todoListId=Long.parseLong(br.readLine());
  }

  public Long returnCategoryId(String whatTodo) throws IOException{
    if(!findAllCategory()){
      return 0L;
    }
    System.out.print(whatTodo+" 카테고리 번호 입력: ");
    return categoryListId=Long.parseLong(br.readLine());
  }

  public boolean findAllCategory(){
    ArrayList<TodoCategoryDTO> categoryList=todoListRepository.findAllCategory();
    if(categoryList==null) return false;
    for(TodoCategoryDTO category:categoryList){
      System.out.println(category);
    }
    return true;
  }

  private boolean categoryDuplicationCheck(String categoryName){
    if(todoListRepository.categoryDuplicationCheck(categoryName)){
      System.out.println("이미 존재하는 카테고리");
      return true;
    }
    System.out.println("존재하지 않아 추가 가능한 카테고리");
    return false;
  }
  
  public boolean findIncompletedTodoList(){
    ArrayList<TodoListDTO> incompletedList=todoListRepository.findIncompletedTodoList();
    if(incompletedList.isEmpty()){
      printEmptyList();
      return false;
    }
    else{
      for(TodoListDTO todo:incompletedList){
        System.out.println(todo);
      }
    }
    return true;
  }

  public boolean findCompletedTodoList(){
    ArrayList<TodoListDTO> completedList=todoListRepository.findCompletedTodoList();
    if(completedList.isEmpty()){
      printEmptyList();
      return false;
    }
    else{
      for(TodoListDTO todo:completedList){
        System.out.println(todo);
      }
    }
    return true;
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
    TodoCategoryDTO newCategory=new TodoCategoryDTO(++categoryListId, "내 할 일 목록", "기본 내 할 일");
    todoListRepository.saveCategory(newCategory);
    newCategory=new TodoCategoryDTO(++categoryListId,"완료한 할 일 목록","완료한 할 일 목록");
    todoListRepository.saveCategory(newCategory);
  }

  public void saveTodo() throws IOException{
    System.out.print("새로 할 일 내용 입력: ");
    String todoContent=br.readLine();
    if(todoContent==null){
      TodoListMain.PrintWrongNum();
    }
    Long categoryId=returnCategoryId("찾음");
    String categoryName=todoListRepository.findCategoryNameByCategoryId(categoryId);
    if(categoryName==null){
      TodoListMain.PrintWrongNum();
    }
    else{
      System.out.print("마감일 입력(YYYY.MM.DD.): ");
      String todoDeadline=br.readLine();
      SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.DD.");
      String todoCreateDate = sdf.format(Calendar.getInstance().getTime());
      TodoListDTO newTodo=new TodoListDTO(++todoListId, todoContent, categoryName, todoDeadline, todoCreateDate);
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
      TodoCategoryDTO newCategory=new TodoCategoryDTO(++categoryListId,categoryName,categoryDiscription);
      if(todoListRepository.saveCategory(newCategory)){
        System.out.println("카테고리 저장 성공");
      }
      else{
        System.out.println("카테고리 저장 실패");
      }
      findAllCategory();
    }
  }

  public void updateTodoContents() throws IOException{
    Long todoId=returnTodoId("내용을 수정할");
    if(todoId.equals(0L)){
      return;
    }
    System.out.print("수정할 내용 입력: ");
    String content=br.readLine();
    if(todoListRepository.updateTodoContents(todoId,content)){
      printUpdateSuccess();
    }
    else{
      printUpdateFail();
    }
    findIncompletedTodoList();
  }

  public void updateTodoCompleted() throws IOException{
    Long todoId=returnTodoId("완료할");
    if(todoId.equals(0L)){
      return;
    }
    if(todoListRepository.updateTodoCompleted(todoId)){
      printUpdateSuccess();
    }
    else{
      printUpdateFail();
    }
    findIncompletedTodoList();
  }

  public void updateCategory() throws IOException{
    Long todoId=returnTodoId("카테고리를 수정할");
    if(todoId.equals(0L)){
      return;
    }
    Long categoryId=returnCategoryId("수정할");
    if(categoryId.equals(0L)){
      return;
    }
    String categoryName=todoListRepository.findCategoryNameByCategoryId(categoryId);
    if(categoryName==null){
      TodoListMain.PrintWrongNum();
    }
    else{
      if(todoListRepository.updateCategory(todoId,categoryName)){
        printUpdateSuccess();
      }
      else{
        printUpdateFail();
      }
      findIncompletedTodoList();
    }
  }

  public void updateDeadline() throws IOException{
    Long todoId=returnTodoId("마감일을 수정할");
    if(todoId.equals(0L)){
      return;
    }
    System.out.print("마감일 입력: ");
    String deadline=br.readLine();
    if(todoListRepository.updateDeadline(todoId, deadline)){
      printUpdateSuccess();
    }
    else{
      printUpdateFail();
    }
    findIncompletedTodoList();
  }

  public void updateCategoryName() throws IOException{
    Long categoryId=returnCategoryId("수정할");
    if(categoryId.equals(0L)){
      return;
    }
    System.out.print("새 카테고리 이름 입력: ");
    String categoryName=br.readLine();
    if(categoryName==null){
      TodoListMain.PrintWrongNum();
    }
    else{
      if(todoListRepository.updateCategoryName(categoryId,categoryName)){
        printUpdateSuccess();
      }
      else{
        printUpdateFail();
      }
      findAllCategory();
    }
  }

  public void deleteTodo() throws IOException{
    Long todoId=returnTodoId("삭제할");
    if(todoListRepository.deleteTodo(todoId)){
      printDeleteSuccess();
    }
    else{
      printDeleteFail();
    }
    findIncompletedTodoList();
  }

  public void deleteAllCompleted(){
    if(todoListRepository.deleteAllCompleted()){
      printDeleteSuccess();
    }
    else{
      printDeleteFail();
    }
    findCompletedTodoList();
  }

  public void deleteCategory() throws IOException{
    Long categoryId=returnCategoryId("삭제할");
    if(todoListRepository.deleteCategory(categoryId)){
      printDeleteSuccess();
    }
    else{
      printDeleteFail();
    }
    findAllCategory();
  }

  private void printEmptyList(){
    System.out.println("목록이 존재하지 않음");
  }
  
  private void printUpdateSuccess(){
    System.out.println("수정 완료");
  }

  private void printUpdateFail(){
    System.out.println("수정 실패");
  }

  private void printDeleteSuccess(){
    System.out.println("삭제 완료");
  }

  private void printDeleteFail(){
    System.out.println("삭제 실패");
  } 
}