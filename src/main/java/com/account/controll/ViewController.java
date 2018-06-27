package com.account.controll;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.omg.PortableInterceptor.ACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.account.domain.Account;
import com.account.domain.AccountFX;
import com.account.domain.Category;
import com.account.domain.CategoryFX;
import com.account.mapper.AccountMapper;
import com.account.mapper.CategoryMapper;
import com.account.mapper.StaticsMapper;
import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

@Component
public class ViewController {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	AccountMapper mapper;

	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	StaticsMapper staticsMapper;

	@FXML
	private TableColumn<AccountFX, String> content;

	@FXML
	private TableColumn<AccountFX, Date> input_date;

	@FXML
	private TableColumn<AccountFX, Integer> money;

	@FXML
	private TableColumn<AccountFX, Integer> input_nn;

	@FXML
	private TableColumn<AccountFX, Integer> inout;

	@FXML
	private TableColumn<AccountFX, String> category;
	
	@FXML
	private TableColumn<AccountFX, String> statics_category;
	
	@FXML
	private TableColumn<AccountFX, String> statics_money;
	

	@FXML
	private TableView<AccountFX> accountTable;
	
	@FXML
	private TableView<AccountFX> staticsTable;

	@FXML
	private VBox dateFixkerVBox;

	@FXML
	private ComboBox<String> cbxCategory;

	@FXML
	private TextField txfMoney;

	@FXML
	private RadioButton rbtIncome;

	@FXML
	private RadioButton rbtOutcome;


	@FXML
	private TextField txfContent;

	@FXML
	private DatePicker dp;
	
	@FXML
	private PieChart chart;

	private ObservableList<AccountFX> data;
	
	private ObservableList<AccountFX> staticData;
	
	private ObservableList<String> categoryData;


    private ObservableList<String> monthNames = FXCollections.observableArrayList();

	private DatePicker datePicker;
	ObservableList<PieChart.Data> pieChartData;
	private void selectCategory(int category_type)
	{
		categoryData = FXCollections.observableArrayList();
		cbxCategory.getItems().removeAll(cbxCategory.getItems());
		try {

			Category param = new Category();
			param.setCategory_type(category_type);
			List li=categoryMapper.selectCategory(param);
			Iterator<Category> iter = li.iterator();
			while(iter.hasNext())
			{
				categoryData.add(new CategoryFX(iter.next()).toString());
			}
			cbxCategory.setItems(categoryData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("error: "+e.getMessage());
			alert.show();
		}
	}

	@FXML
	private void initialize()
	{
		rbtIncome.setOnAction(e->{
			selectCategory(1);
		});
		rbtOutcome.setOnAction(e->{
			selectCategory(2);
		});
		Account param = new Account();
		

		datePicker = new DatePicker(LocalDate.now());
		datePicker.setOnAction(new EventHandler() {
		     public void handle(Event t) {
		         LocalDate date = datePicker.getValue();
		         
		         try {
		 			param.setInput_date(formatter.parse(date.toString()));
		 		} catch (ParseException e1) {
		 			// TODO Auto-generated catch block
		 			e1.printStackTrace();
		 		}
		 		List li=staticsMapper.selectCurentMonthSpandingRate(param);
				pieChartData = FXCollections.observableArrayList();
				staticData =FXCollections.observableArrayList();
				Iterator iter = li.iterator();
				while(iter.hasNext())
				{
					Account item = (Account) iter.next();
					pieChartData.add(new PieChart.Data(item.getCategory(), item.getMoney()));
					staticData.add(new AccountFX(item));
				}
				
				statics_money.setCellValueFactory(new PropertyValueFactory<>("money"));
				statics_category.setCellValueFactory(new PropertyValueFactory<>("category"));
				staticsTable.setItems(staticData);
				
				chart.setData(pieChartData);
		     }
		 });
		DatePickerSkin datePickerSkin=new DatePickerSkin(datePicker);
		Node popupContent = datePickerSkin.getPopupContent();
		dateFixkerVBox.getChildren().add(popupContent);

	}

	@FXML
	private void select(ActionEvent event)
	{
		load();
	}
	public ViewController() {

	}
	private void load()
	{
		try {
			data = FXCollections.observableArrayList();
			
			Account param = new Account();
			param.setInout_type(Account.SPADING);
			//param.setInput_date(date);			

			List li=mapper.selectAccount(param);

			Iterator<Account> iter = li.iterator();
			
			while(iter.hasNext())
			{
				data.add(new AccountFX(iter.next()));
			}
			money.setCellValueFactory(new PropertyValueFactory<>("money"));
			content.setCellValueFactory(new PropertyValueFactory<>("content"));
			input_nn.setCellValueFactory(new PropertyValueFactory<>("input_nn"));
			input_date.setCellValueFactory(new PropertyValueFactory<>("input_date"));
			//inout.setCellValueFactory(new PropertyValueFactory<>("inout"));
			//content.setCellValueFactory(new PropertyValueFactory<>("category"));
			accountTable.setItems(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	private void delete(ActionEvent event)
	{
		AccountFX selectedItem = accountTable.getSelectionModel().getSelectedItem();
		if(selectedItem==null)
			return;
		Account param = new Account();
		param.setInput_nn(selectedItem.getInput_nn());
		try {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("delete?"+param.getInput_nn());
			Optional<ButtonType> action = alert.showAndWait();
			if(action.get()== ButtonType.OK)
				mapper.deleteAccount(param);
			load();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	private void insertGategory(ActionEvent event)
	{
		
	}
	
	@FXML
	private void deleteGategory(ActionEvent event)
	{
		
	}
	
	@FXML
	private void insert(ActionEvent event)
	{
		String input_date = dp.getValue().toString();

		String content = txfContent.getText();

		int money= Integer.parseInt(txfMoney.getText());

		try {
			Account param = new Account();
			param.setContents(content);
			param.setMoney(money);
			param.setInput_date(formatter.parse(input_date));

			mapper.insertAccount(param);

			load();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ParseException ex)
		{
			System.out.println(ex.getMessage()+" 날짜 오류");
		}
	}
	@FXML
	private  void showdate(ActionEvent event)
	{
		LocalDate date = dp.getValue();

	}
}
