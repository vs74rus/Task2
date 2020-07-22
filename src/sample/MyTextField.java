package sample;

import javafx.scene.control.TextField;


//Расширение класса TextField для проверки ввода в поле
public class MyTextField extends TextField {

     public MyTextField() {
         this.setPromptText("Ввод только для цифр!");
     }

    @Override
    public void replaceText(int i, int i1, String s) {
        //регулярное выражение - только цифры и точка
         if (s.matches("[0-9-]") ||  s.isEmpty()) {
             super.replaceText(i, i1, s);
        }
    }

    @Override
    public void replaceSelection(String s) {
              super.replaceSelection(s);

    }
}
