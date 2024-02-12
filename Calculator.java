import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton,subButton,mulButton,divButton,negButton;
    JButton decButton,equButton,delButton,clrButton,remButton;
    JPanel panel;

    Font myFont =new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    Calculator(){
        frame =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textfield =new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        remButton=new JButton("%");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("AC");
        negButton=new JButton("(-)");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=remButton;
        functionButtons[5]=decButton;
        functionButtons[6]=equButton;
        functionButtons[7]=delButton;
        functionButtons[8]=clrButton;
        functionButtons[9]=negButton;

        for(int i=0;i<10;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }


        delButton.setBounds(110,430,150,50);


        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.add(clrButton);
        panel.add(negButton);
        panel.add(remButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);



        frame.add(panel);
        frame.add(delButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
    }
    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat(String.valueOf(".")));
        }
        if(e.getSource()==addButton){
            num1= Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton){
            num1= Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton){
            num1= Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton){
            num1= Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        if(e.getSource()==remButton){
            num1= Double.parseDouble(textfield.getText());
            operator='%';
            textfield.setText("");
        }
        if(e.getSource()==equButton){
            num2= Double.parseDouble(textfield.getText());

            switch(operator){
                case'+': result=num1+num2; break;
                case'-': result=num1-num2; break;
                case'*': result=num1*num2; break;
                case'/': result=num1/num2; break;
                case'%': result=num1%num2; break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textfield.setText("");
        }
        if(e.getSource()==delButton){
            String string =textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp=Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
