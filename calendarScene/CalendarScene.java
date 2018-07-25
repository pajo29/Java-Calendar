package calendarScene;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;

public class CalendarScene extends BorderPane{
	
	private static CalendarScene instance = null;
	
	private ComboBox<String> cmbYear;
	private ObservableList<String> years = FXCollections.observableArrayList();
	
	private Button btnRight;
	private Button btnLeft;
	private Button btnChangeYear;
	
	private Label monthLabel;
	
	private TableView<Week> calendarTable;
	private TableColumn<Week, String> calendarClmMonday;
	private TableColumn<Week, String> calendarClmTuesday;
	private TableColumn<Week, String> calendarClmWednesday;
	private TableColumn<Week, String> calendarClmThursday;
	private TableColumn<Week, String> calendarClmFriday;
	private TableColumn<Week, String> calendarClmSaturday;
	private TableColumn<Week, String> calendarClmSunday;
	
	private CalendarMaker calendar;
	
	private Year year;
	private Month month;
	
	private CalendarScene()
	{
		calendar = CalendarMaker.getInstance();
		cmbYear = new ComboBox<>();
		
		monthLabel = new Label();
		
		for(Year years: calendar.getYears())
		{
			this.years.add(years.toString());
		}
		cmbYear.getItems().addAll(years);
        
		btnRight = new Button();
		btnRight.setStyle("-fx-background-image: url('file:images/arrowRight.png')");
		btnRight.setPrefSize(45, 45);
		btnLeft = new Button();
		btnLeft.setStyle("-fx-background-image: url('file:images/arrowLeft.png')");
		btnLeft.setPrefSize(45, 45);
		btnChangeYear = new Button("Promeni godinu");
		
		btnChangeYear.setOnAction(e ->
		{
			changeYear();
		});
		
		btnRight.setOnAction(e ->
		{
			changeMonthRight();
		});

		btnLeft.setOnAction(e ->
		{
			changeMonthLeft();
		});
		
		calendarTable = new TableView<>();
		calendarTable.setMaxHeight(475);
		calendarClmMonday = new TableColumn<>("Monday");
		calendarClmTuesday = new TableColumn<>("Tuesday");
		calendarClmWednesday = new TableColumn<>("Wednesday");
		calendarClmThursday = new TableColumn<>("Thursday");
		calendarClmFriday = new TableColumn<>("Friday");
		calendarClmSaturday = new TableColumn<>("Saturday");
		calendarClmSunday = new TableColumn<>("Sunday");
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		calendarClmMonday.setCellValueFactory(new PropertyValueFactory<>("monday"));
		calendarClmMonday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmMonday.setResizable(false);
		calendarClmMonday.setSortable(false);
		calendarClmTuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
		calendarClmTuesday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmTuesday.setResizable(false);
		calendarClmTuesday.setSortable(false);
		calendarClmWednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
		calendarClmWednesday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmWednesday.setResizable(false);
		calendarClmWednesday.setSortable(false);
		calendarClmThursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
		calendarClmThursday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmThursday.setResizable(false);
		calendarClmThursday.setSortable(false);
		calendarClmFriday.setCellValueFactory(new PropertyValueFactory<>("friday"));
		calendarClmFriday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmFriday.setResizable(false);
		calendarClmFriday.setSortable(false);
		calendarClmSaturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));
		calendarClmSaturday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmSaturday.setResizable(false);
		calendarClmSaturday.setSortable(false);
		calendarClmSunday.setCellValueFactory(new PropertyValueFactory<>("sunday"));
		calendarClmSunday.setPrefWidth(primaryScreenBounds.getWidth()/7);
		calendarClmSunday.setResizable(false);
		calendarClmSunday.setSortable(false);
		calendarTable.setSelectionModel(null);
		
		
		
		Date defaultDate = Calendar.getInstance().getTime();
		
		for(Year years: calendar.getYears())
		{
			if(defaultDate.getYear()+1900 == years.getYearNumber())
			{
				year = years;
				for(Month months: year.getMonths())
				{
					if(months.getMonthNumber() == (defaultDate.getMonth()+1))
					{
						month = months;
					}
				}
			}
			for(String cmbYears: this.years)
			{
				if(defaultDate.getYear()+1900 == Integer.parseInt(cmbYears))
				{
					this.cmbYear.setPromptText(cmbYears);
				}
			}
			
		}
		
		calendarTable.getColumns().addAll(calendarClmMonday, calendarClmTuesday, calendarClmWednesday, calendarClmThursday, calendarClmFriday, calendarClmSaturday, calendarClmSunday);
		
		setTableValues(year, month);
		
		monthLabel.setText(month.toString());
		
		HBox h = new HBox(15);
		h.setAlignment(Pos.CENTER);
		h.getChildren().addAll(btnChangeYear, cmbYear, btnLeft, monthLabel, btnRight);
		
		setTop(h);
		setCenter(calendarTable);
		setAlignment(calendarTable, Pos.TOP_CENTER);
	}
	
	public static CalendarScene getInstance()
	{
		if(instance == null)
		{
			instance = new CalendarScene();
		}
		return instance;
	}
	
	private void setTableValues(Year year, Month month)
	{
		calendarTable.setItems(calendar.getWeeks(year.getMonths().get(month.getMonthNumber()-1)));
		calendarTable.refresh();
	}
	
	private void changeYear()
	{
		for(Year years: calendar.getYears())
		{
			if(cmbYear.getSelectionModel().getSelectedItem().equals(Integer.toString(years.getYearNumber())))
			{
				year = years;
				setTableValues(year, month);
			}
		}
	}
	
	private void changeMonthRight()
	{
		for(Month months: year.getMonths())
		{
			if(months.getMonthNumber() == month.getMonthNumber()+1)
			{
				month = months;
				setTableValues(year, month);
				monthLabel.setText(month.toString());
				return;
			}
		}
	}
	
	private void changeMonthLeft()
	{
		for(Month months: year.getMonths())
		{
			if(months.getMonthNumber() == month.getMonthNumber()-1)
			{
				month = months;
				setTableValues(year, month);
				monthLabel.setText(month.toString());
				return;
			}
		}
	}
	
	
	
	
	
	
	
	

}
