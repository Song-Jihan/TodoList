package todoList;

public class TodoListDTO {
  
  private Long todoId;
  private String todoTitle;
  private String todoContent;
  private String todoCategory;
  private String todoDeadline;
  private String beforeCategory;
  
  public TodoListDTO(){}
  
  public TodoListDTO(Long todoId,String todoTitle, String todoContent, String todoCategory, String todoDeadline){
    this.todoId=todoId;
    this.todoTitle=todoTitle;
    this.todoContent=todoContent;
    this.todoCategory=todoCategory;
    this.todoDeadline=todoDeadline;
    beforeCategory=todoCategory;
  }
  
  public Long getTodoId(){
    return todoId;
  }
  
  public void setTodoId(Long todoId){
    this.todoId=todoId;
  }
  
  public String getTodoTitle(){
    return todoTitle;
  }
  
  public void setTodoTitle(String todoTitle){
    this.todoTitle=todoTitle;
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

  public String getBeforeCategory(){
    return beforeCategory;
  }
  
  public void setBeforeCategory(String beforeCategory){
    this.beforeCategory=beforeCategory;
  }
  
  @Override
  public String toString(){
    return "ToDoListDTO {todoList="+todoId+", todoTitle="+todoTitle+", todoContent="+todoContent+", todoCategory="+todoCategory+", todoDeadline="+todoDeadline+", beforeCategory="+beforeCategory+"}";
  }
  
}