package todoList;

public class TodoListDTO {
  
  private Long todoId;
  private String todoContent;
  private String todoCategory;
  private String todoDeadline;
  private String todoCreateDate;
  
  public TodoListDTO(){}
  
  public TodoListDTO(Long todoId,String todoContent, String todoCategory, String todoDeadline, String todoCreateDate){
    this.todoId=todoId;
    this.todoContent=todoContent;
    this.todoCategory=todoCategory;
    this.todoDeadline=todoDeadline;
    this.todoCreateDate=todoCreateDate;
  }
  
  public Long getTodoId(){
    return todoId;
  }
  
  public void setTodoId(Long todoId){
    this.todoId=todoId;
  }
  
  public String getTodoContent(){
    return todoContent;
  }
  
  public void setTodoContent(String todoContent){
    this.todoContent=todoContent;
  }
  
  public String getTodoCategory(){
    return todoCategory;
  }
  
  public void setTodoCategory(String todoCategory){
    this.todoCategory=todoCategory;
  }
  
  public String getTodoDeadline(){
    return todoDeadline;
  }
  
  public void setTodoDeadline(String todoDeadline){
    this.todoDeadline=todoDeadline;
  }
  
  public String getTodoCreateDate(){
    return todoCreateDate;
  }
  
  public void setTodoCreateDate(String todoCreateDate){
    this.todoCreateDate=todoCreateDate;
  }
  
  @Override
  public String toString(){
    return "ToDoListDTO {todoList="+todoId+", todoContent="+todoContent+", todoCategory="+todoCategory
            +", todoDeadline="+todoDeadline+", todoCreateDate="+todoCreateDate+"}";
  }
  
}