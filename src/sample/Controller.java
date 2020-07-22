package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

class MyClass {
    //объявление массива
    //для хранения инфы во время всё программы
    static double myArray[][] = new double[10][2];
}

public class Controller implements Initializable {
    @FXML
    public TableView<Matrix> table1;
    @FXML
    public Button btnFillNum;
    @FXML
    public Button btnExec;
    @FXML
    public TableColumn<Matrix, String> col1;
    @FXML
    public TableColumn<Matrix, String> col2;
    @FXML
    public Button btnClear;
    @FXML
    public Button btnClose;
    @FXML
    private MyTextField textField1;
    @FXML
    private MyTextField textField2;
    @FXML
    public Button btnFillAB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        col2.setCellValueFactory(new PropertyValueFactory<>("col2"));
    }

    //обработка нажатия кнопки Заполнить
    public void onClickBtnFillNum(ActionEvent actionEvent) {
        table1.getItems().clear();
        for (int i = 0; i < MyClass.myArray.length; i++) {
            Matrix mat = new Matrix();
            MyClass.myArray[i][0] = Math.random() * 20;
            mat.setCol1(MyClass.myArray[i][0]);
            table1.getItems().add(mat);
        }

    }
    //обработка нажатия кнопки Выполнить задание
    public void onClickBtnExec(ActionEvent actionEvent) {
        if ((textField1.getText().equals("")) || (textField2.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Внимание!");
            alert.setHeaderText(null);
            alert.setContentText("Нарушено условие, при котором пример имеет решение!");
            alert.showAndWait();
        }
        else {
            table1.getItems().clear();
            Matrix mat1 = new Matrix();
            mat1.setCol1(MyClass.myArray[0][0]);
            mat1.setCol2(MyClass.myArray[0][1]);
            table1.getItems().add(mat1);
            for (int i = 1; i < MyClass.myArray.length; i++) {
                int a = Integer.parseInt(textField1.getText());
                int b = Integer.parseInt(textField2.getText());
                double K = MyClass.myArray[i][0];
                if ((K != 0) && (a != 0) && (b != 0)) {
                    Matrix mat = new Matrix();
                    double h1 = Math.pow(K, 2);
                    double h2 = (Math.pow(a, 2) + Math.pow(b, 2)) - Math.sin(K);
                    double h3 = Math.sqrt(h1 / h2);
                    double sumKi = 0.0;
                    //суммирование K(i-1-ых)
                    for (int j = 0; j <= i - 1; j++)
                        sumKi += MyClass.myArray[j][0];
                    MyClass.myArray[i][1] = h3 * sumKi;
                    mat.setCol1(MyClass.myArray[i][0]);
                    mat.setCol2(MyClass.myArray[i][1]);
                    table1.getItems().add(mat);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Внимание!");
                    alert.setHeaderText(null);
                    alert.setContentText("Нарушено условие, при котором пример имеет решение!");
                    alert.showAndWait();
                    break;
                }
            }
        }

    }
    //Обработчик кнопки Выход
    public void onclickbtnExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    //Обработчик нажания кнопки Очистить
    public void onClickBtnClear(ActionEvent actionEvent) {
       table1.getItems().clear();
       textField1.clear();
       textField2.clear();
    }

    //обработчик нажатия кнопки Заполнить а и b
    public void onClickbtnFillAB(ActionEvent actionEvent) {
        textField1.setText( Integer.toString((int) (Math.random() * 20)-10));
        textField2.setText( Integer.toString((int) (Math.random() * 20)-10));
    }
}

