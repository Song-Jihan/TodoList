package todoList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TodoListMain {
  public static void main(String[] args){
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    boolean run=true;
    int selectNum=0;
    
    TodoListService todoListService=new TodoListService();
    
    while(run){
      try{
        System.out.println("1.할 일 보기 | 2.추가하기 | 3.수정하기 | 4.삭제하기 | 5.나가기");
        PrintSetNum();
        selectNum=Integer.parseInt(br.readLine());
        
        switch(selectNum){
          case 1: // 1.할 일 보기
            boolean run1=true;
            while(run1){
              System.out.println("1.모든 할 일 보기 | 2.카테고리별 보기 | 3.완료한 할 일 보기 | 4.뒤로가기");
              PrintSetNum();
              selectNum=Integer.parseInt(br.readLine());
  
              switch(selectNum){
                case 1: // 1.모든 할 일 보기
                  todoListService.findTodoList();
                  break;
                case 2: // 2.카테고리별 보기
                  todoListService.findTodoListbyCategory();
                  break;
                case 3: // 3.완료한 할 일 보기
                  todoListService.findCompletedTodoList();
                  break;
                case 4:// 4.뒤로가기
                  run1=false;
                  break;
                default:
                  PrintWrongNum();
              }
            }
            break;
            
          case 2: // 2.추가하기
            boolean run2=true;
            while(run2){
              System.out.println("1.새 할 일 추가 | 2.카테고리 추가 | 3.뒤로가기");
              PrintSetNum();
              selectNum=Integer.parseInt(br.readLine());
  
              switch(selectNum){
                case 1: // 1.새 할 일 추가
                  todoListService.Newtodo();
                  break;
                case 2: // 2.카테고리 추가
                  todoListService.Newcatagory();
                  break;
                case 3: // 3.뒤로가기
                  run2=false;
                  break;
                default:
                  PrintWrongNum();
              }
            }
            break;
            
          case 3: // 3.수정하기
            boolean run3=true;
            while(run3){
              System.out.println("1.할 일 내용 수정 | 2.할 일 완료 | 3.할 일 카테고리 이동 | 4.할 일 마감일 수정 | 5.카테고리 이름 수정 | 6.뒤로가기");
              PrintSetNum();
              selectNum=Integer.parseInt(br.readLine());
  
              switch(selectNum){
                case 1: // 1.할 일 내용 수정
                  todoListService.updateTodoContents();
                  break;
                case 2: // 2.할 일 완료
                  todoListService.updateTodoComplete();
                  break;
                case 3: // 3.할 일 카테고리 이동
                  todoListService.updateTodoCategory();
                  break;
                case 4: // 4.할 일 마감일 수정
                  todoListService.updateDeadline();
                  break;
                case 5: // 5.카테고리 이름 수정
                  todoListService.updateCategoryName();
                  break;
                case 6: // 6.뒤로가기
                  run3=false;
                  break;
                default:
                  PrintWrongNum();
              }
            }
            break;
          case 4:
            boolean run4=true;
            while(run4){
              System.out.println("1.할 일 삭제 | 2.완료한 할 일 모두 삭제 | 3.카테고리 삭제 | 4.뒤로가기");
              PrintSetNum();
              selectNum=Integer.parseInt(br.readLine());
  
              switch(selectNum){
                case 1:
                  todoListService.deleteTodoList();
                  break;
                case 2:
                  todoListService.deleteAllOfCompletedList();
                  break;
                case 3:
                  todoListService.deleteCategory();
                  break;
                case 4:
                  run4=false;
                  break;
                default:
                  PrintWrongNum();
              }
            }
            break;
          case 5:
            run=false;
            break;
          default:
            PrintWrongNum();
        }
        
      }catch(NumberFormatException e) {
				System.out.println("InputMismatchException 예외 발생!!");
				System.out.println("숫자를 입력하세요.");
      }catch (IOException e) {
        System.out.println("입력 오류 발생");
      }
      
    }
  }
  
  static void PrintSetNum(){System.out.print("번호 입력: ");}
  
  static void PrintWrongNum(){System.out.println("잘못된 숫자 입력입니다.");}
  
}