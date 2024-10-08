import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // hold icon names
   private final JLabel label; // displays selected icon

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])),//faz leitura do metodo. names zero=bug1.gif
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");//metodo q deifne titulo
      setLayout(new FlowLayout()); // metodo que define o tipo de quadro. flowlayout é o fluxo de exibição de objetos no layout da janela

      imagesJComboBox = new JComboBox<String>(names); // deifne tipo de objeto que vai atribuir para variável que recebe nov objeto. define informaçoes por tag. name mostra o nome das imagens que aparecerá na lista suspensa
      imagesJComboBox.setMaximumRowCount(3); // define numero maximo de contagem de linhas a serem exibidas na lista suspensa.

      imagesJComboBox.addItemListener(//invoca metodo do escutador do item ao clicar em algum item da caixa suspensa. 
         new ItemListener() // novo objeto itemlistener que precisou ser criado com o msm nome do metodo invocado
         {
            
            @Override// override sobrescreve o método abaixo
            public void itemStateChanged(ItemEvent event)//metodo que recebe o parametro event do tipo itemevent
            {//bloco de codigo do metodo itemstatechanged
               
               if (event.getStateChange() == ItemEvent.SELECTED)//verifica se event--. coleta o esttado em que o item está. se selecionado mostra, senao ignora. 
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);//coleta numero 
            } 
         } // end anonymous inner class
      ); // end call to addItemListener

      add(imagesJComboBox); // adiciona imagejcombobox na inicialização
      label = new JLabel(icons[0]); // display first icon
      add(label); // add label to JFrame
   }
} // end class ComboBoxFrame


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
