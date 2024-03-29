import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

class Test {

   public static void main(String[] args) {
   
      Runnable r = 
         new Runnable() {
         
            public void run() {
               final JFrame frame = new JFrame("Windows Optimizer");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
               final JPanel gui = new JPanel(new BorderLayout(5,5));
               gui.setBorder( new TitledBorder("Automic, advanced, default"));
            
            //JToolBar tb = new JToolBar();
               JPanel plafComponents = new JPanel(
                  new FlowLayout(FlowLayout.RIGHT, 3,3));
              // plafComponents.setBorder(
               //   new TitledBorder("Automic, advanced, default"));
            
               final UIManager.LookAndFeelInfo[] plafInfos =
                  UIManager.getInstalledLookAndFeels();
               String[] plafNames = new String[plafInfos.length];
               for (int ii=0; ii<plafInfos.length; ii++) {
                  plafNames[ii] = plafInfos[ii].getName();
               }
               final JComboBox plafChooser = new JComboBox(plafNames);
               plafComponents.add(plafChooser);
            
            /*      final JCheckBox pack = new JCheckBox("Pack on PLAF change", true);
            plafComponents.add(pack);*/  
            
               plafChooser.addActionListener( 
                  new ActionListener(){
                     public void actionPerformed(ActionEvent ae) {
                        int index = plafChooser.getSelectedIndex();
                        try {
                           UIManager.setLookAndFeel(
                              plafInfos[index].getClassName() );
                           SwingUtilities.updateComponentTreeUI(frame);
                        /*                if (pack.isSelected()) {
                        frame.pack();
                        frame.setMinimumSize(frame.getSize());
                        }*/
                        } catch(Exception e) {
                           e.printStackTrace();
                        }
                     }
                  } );
            // // // // // // // // // // // // // // // // // // // // // // // // // 
            
            //          gui.add(plafComponents, BorderLayout.NORTH); 
            //                JPanel menuOptions = new JPanel(new GridLayout(2, 1)); 
            //                menuOptions.setBorder(new TitledBorder("Main Menu")); 
            //                gui.add(menuOptions, BorderLayout.WEST);
            //                
            //                Dimension size = new Dimension(150, 50); //important
            //                
            //                JButton button = new JButton("TCP Optimizer");
            //                button.setPreferredSize(size);
            //                menuOptions.add(button, GridLayout());
            //    //                
            //             //                JButton button1 = new JButton("Storage Optimizer"); 
            //             //                button1.setPreferredSize(size); 
            //             //                menuOptions.add(button1, BorderLayout.CENTER);
            //                gui.add(plafComponents, BorderLayout.NORTH); 
            //                JPanel menuOptions = new JPanel(new GridLayout(2, 1)); 
            //                menuOptions.setBorder(new TitledBorder("Main Menu")); 
            //                gui.add(menuOptions, BorderLayout.WEST); 
            //                Dimension size = new Dimension(150, 50); //important 
            //                JButton button = new JButton("TCP Optimizer");
            //                button.setPreferredSize(size); menuOptions.add(button);
            //                JButton button1 = new JButton("Storage Optimizer");
            //                button1.setPreferredSize(size);
            //                menuOptions.add(button1);
            //                
               gui.add(plafComponents, BorderLayout.NORTH);
            
               JPanel menuOptions = new JPanel();
               menuOptions.setLayout(new BoxLayout(menuOptions, BoxLayout.Y_AXIS)); // Set vertical layout
               menuOptions.setBorder(new TitledBorder("Main Menu"));
               gui.add(menuOptions, BorderLayout.WEST);
            
               Dimension size = new Dimension(150, 50);
            
               JButton button = new JButton("   TCP Optimizer    ");
               button.setPreferredSize(size);
               menuOptions.add(button);
            
               JButton button1 = new JButton("Storage Optimizer");
               button1.setPreferredSize(size);
               menuOptions.add(button1);
            
               gui.setVisible(true);
                  
              //  Button tcpOP = new Button("TCP Optimization"); 
            //                Button storageOP = new Button("Storage Optimization"); 
            //                Button as = new Button(""); tcpOP.setBounds(30, 30, 150, 50); 
            //                storageOP.setBounds(30, 80, 150, 50);
            //                as.setBounds(40, 90, 50, 50); 
            //                add(tcpOP); 
            //                add(storageOP); 
            //                add(as);
            // // // // // // // // // // // // // // // // // // // // // // // // // 
               String[] header = {"NameofOption", "Options"};
               String[] a = new String[0];
               String[] names = System.getProperties().
                  stringPropertyNames().toArray(a);
               String[][] data = new String[names.length][2];
            
            //  final JCheckBox pack = new JCheckBox("True?", true);
            //        data[0][1] = plafComponents.add(pack);
            
               DefaultTableModel model = new DefaultTableModel(data, header);
               JTable table = new JTable(model);
               try {
                  table.setAutoCreateRowSorter(true);
               } catch(Exception continuewithNoSort) {
               }
               JScrollPane tableScroll = new JScrollPane(table);
               Dimension tablePreferred = tableScroll.getPreferredSize();
               tableScroll.setPreferredSize(
                  new Dimension(tablePreferred.width, tablePreferred.height/3) );
            
               JPanel imagePanel = new JPanel(new GridBagLayout());
               imagePanel.setBorder(
                  new TitledBorder("Option for Speedtest"));
            
            /*       BufferedImage bi = new BufferedImage(
               200,200,BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bi.createGraphics();
            GradientPaint gp = new GradientPaint(
               20f,20f,Color.red, 180f,180f,Color.yellow);
            g.setPaint(gp);
            g.fillRect(0,0,200,200);
            ImageIcon ii = new ImageIcon(bi);
            JLabel imageLabel = new JLabel(ii);
            imagePanel.add( imageLabel, null );*/
            
               JSplitPane splitPane = new JSplitPane(
                  JSplitPane.VERTICAL_SPLIT,
                  tableScroll,
                  new JScrollPane(imagePanel));
               gui.add( splitPane, BorderLayout.CENTER );
            
               frame.setContentPane(gui);
            
               frame.pack();
            
               frame.setLocationRelativeTo(null);
               try {
               // 1.6+
                  frame.setLocationByPlatform(true);
                  frame.setMinimumSize(frame.getSize());
               } catch(Throwable ignoreAndContinue) {
               }
            
               frame.setVisible(true);
            }
         };
      SwingUtilities.invokeLater(r);
   }
}