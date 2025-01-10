package todoList;

public class TodoCategoryDTO {
  
  private Long categoryId;
  private String categoryName;
  private String categoryDiscription;
  
  public TodoCategoryDTO(){}
  
  public TodoCategoryDTO(Long categoryId,String categoryName, String categoryDiscription){
    this.categoryId=categoryId;
    this.categoryName=categoryName;
    this.categoryDiscription=categoryDiscription;
  }
  
  public Long getCategoryId(){
    return categoryId;
  }
  
  public void setCategoryId(Long categoryId){
    this.categoryId=categoryId;
  }
  
  public String getCategoryName(){
    return categoryName;
  }
  
  public void setCategoryName(String categoryName){
    this.categoryName=categoryName;
  }
  
  public String getCategoryDiscription(){
    return categoryDiscription;
  }
  
  public void setCategoryDiscription(String categoryDiscription){
    this.categoryDiscription=categoryDiscription;
  }
  
  @Override
  public String toString(){
    return "todoCategoryDTO {categoryId="+categoryId+", categoryName="+categoryName
            +", categoryDiscription="+categoryDiscription+"}";
  }
  
}