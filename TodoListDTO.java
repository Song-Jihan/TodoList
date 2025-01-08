package TodoList;

public class TodoListDTO {
  
  private Long todoId;
  private String todoContent;
  private String todoCategory;
  private String todoDeadline;
  private String todoCreateDate;
  
  public TodoListDTO(){}
  
  public TodoListDTO(Long todoId,String todoContent, String todoCategory, String todoDeadline, String todoCreateDate){
    this.todoId=todoId;
    this.todoCategory=todoCategory;
    this.todoDeadline=todoDeadline;
    this.todoCreateDate=todoCreateDate;
  }
  
  public Long gettodoId(){
    return gettodoId;
  }
  
  public void settodoId(Long todoId){
    this.gettodoId=gettodoId;
  }
  
  public String todoContent(){
    return todoContent;
  }
  
  public void settodoContent(String todoContent){
    this.todoCategory=todoCategory;
  }
  
  public String todoCategory(){
    return todoCategory;
  }
  
  public void settodoCategory(String todoCategory){
    this.todoCategory=todoCategory;
  }
  
  public String todoDeadline(){
    return todoDeadline;
  }
  
  public void settodoDeadline(String todoDeadline){
    this.todoDeadline=todoDeadline;
  }
  
  public String todoCreateDate(){
    return todoCreateDate;
  }
  
  public void settodoCreateDate(String todoCreateDate){
    this.todoCreateDate=todoCreateDate;
  }
  
  @Override
  public String toString(){
    return "ToDoListDTO {todoList="+todoId+", todoContent="+todoContent+", todoCategory="+todoCategory
            +", todoDeadline="+todoDeadline+", todoCreateDate="+todoCreateDate+"}";
  }
  
}