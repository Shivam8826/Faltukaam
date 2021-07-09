package com.cg.jpainitialsetup.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.onlinewardrobeapp.domain.Table;
import com.cg.onlinewardrobeapp.service.TableService;
import com.cg.onlinewardrobeapp.serviceimpl.TableServiceImpl;
public class MenuUtil {
private UserService userService;
	
	public MenuUtil() {
		userService=new UserServiceImpl();
	}
	
	public void start() {
		Scanner scan=new Scanner(System.in);
		int optionChoice;
		String continueChoice;
		do {
			showMenu();
			System.out.println("Enter Your Choice : ");
			optionChoice = scan.nextInt();
			switch (optionChoice) {
			case 1:
				User user = getUserInput(scan);				
				userService.createUser(user);
				break;
			case 2:
				System.out.println("--------Table List-----------");
				List<User> tables = userService.listTables();
				for (User tab : tables) {
					System.out.println(tab);
				}
				break;
			case 3:
				System.out.println("Updating Table ");
				List<User> table_list = userService.listTables();
				User update_user = updateUser(table_list);
				userService.updateUser(update_User);
				break;
			case 4:
				System.out.println("Enter the table ID you want to delete");
				int id = getUserId(scan);
				userService.removeUser(id);
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue : (yes/no) : ");
			continueChoice = scan.next();
		}while(continueChoice.equals("yes"));
	}

	private User updateUser(List<User> user_list) {
		
	
		List<User> table = new ArrayList<User>();
		System.out.println("please enter the Project Id you would like to edit from the given projects\n");
		for (User tab : user_list) {
			System.out.println(tab);
		}
		Scanner scan=new Scanner(System.in);
		int enter_id = scan.nextInt();
		for (User tab : user_list) {
			if(tab.getId()==enter_id) {
				System.out.println("press 1 to update name");
				System.out.println("press 2 to update description");
				System.out.println("press 3 to update project id");
				int case_number = scan.nextInt();
				if(case_number == 1) {
					System.out.println("enter name");
					String update_name = scan.next();
					tab.setName(update_name);
				}
				else if(case_number == 2) {
					System.out.println("enter category");
					String update_category = scan.next();
					tab.setCategory(update_category);
				}
				else {
					System.out.println("enter size");
					String update_size = scan.next();
					tab.setSize(update_size);
				}
				table.add(tab);
			}	
				
		}
		scan.close();	
		return table.get(0);
	}


		

	private int getUserId(Scanner scan) {
		int userId = scan.nextInt();
		return userId;
	}

	private User getUserInput(Scanner scan) {
		User user = new User();
		System.out.println("Enter project Name");
		User.setName(scan.next());
		System.out.println("Enter project Category");
		User.setCategory(scan.next());
		System.out.println("Enter project Size");
		User.setSize(scan.next());
		return user;
	}

	private void showMenu() {
		System.out.println("-------Online Wardrobe--------");
		System.out.println("1. Create User");
		System.out.println("2. List User");
		System.out.println("3. Update User");
		System.out.println("4. Delete ");
	}
}

