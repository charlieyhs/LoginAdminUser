
package proyecto;
import java.awt.Component;
import java.util.Vector;
import javax.swing.*;
public class Proyecto {

    public static void login(){
        String cont,user,rol,useraprobado="",contaprobada="";
        int continuar = 0, contador;
        
        while (continuar == 0) {
        // se crean arreglos con usuarios y contraseña.
        String[] Usuario = {"admin1","user2","user3","admin4","user5","admin6","user7","user8","admin9","user10"};
        String[] Contraseña = {"1111","2222","3333","4444","5555","6666","7777","8888","9999","1010"};
        
        // se solicitan datos al usuario
        user = JOptionPane.showInputDialog(null,"Ingrese el nombre de usuario");
        cont = JOptionPane.showInputDialog(null,"Ingrese contraseña"); 
        
        /* ciclos anidados para recorrer los arreglos y comparar si los 
           datos ingresados por el usuario estan registrados en los array.*/
        for(contador=0;contador<10;contador++){
            if (user.equals(Usuario[contador])){
                useraprobado = Usuario[contador];
                for(contador=0;contador<10;contador++){
                    if (cont.equals(Contraseña[contador])){
                    contaprobada = Contraseña[contador];
                    break;
                    } 
                }       
            }
        }
        
        // se comprueba el rol del usuario
        char indice = useraprobado.charAt(0);
        if (indice == 'a'){
            JOptionPane.showMessageDialog(null,"Su rol es administrador.");
            
        } else {
            if (indice == 'u')
            JOptionPane.showMessageDialog(null,"Su rol es usuario.");    
        }
        
        // pregunta para salir o continuar.
        continuar = JOptionPane.showConfirmDialog(null, "¿Desea intentarlo nuevamente?","continuar",JOptionPane.YES_NO_OPTION);
        if(continuar == JOptionPane.YES_OPTION){
            login();
        }else{
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new botones(indice).setVisible(true);
            }
        });
        }
      }
    }
    
    public static void main(String[] args) {
        
        login();

    }
    
}

class botones extends javax.swing.JFrame{
    Vector mi_vector = new Vector();
    Vector codigos = new Vector();
    Vector nombres = new Vector();
    String nombre, cantidad, precioU, codigo, categoria;
    char indice;
    public botones(char indice) {
        this.indice = indice;
        Componentes();
        setLocationRelativeTo(null);
    }
    
    
    private void Componentes() {

        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        mostrar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregar.setText("Agregar Producto");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar Producto");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        mostrar.setText("Mostrar Inventario");
        if(indice=='a'){
            mostrar.setVisible(true);
        }else if(indice=='u'){
            mostrar.setVisible(false);
        }
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        Borrar.setText("Borrar Producto");
        if(indice=='a'){
            Borrar.setVisible(true);
        }else if(indice=='u'){
            Borrar.setVisible(false);
        }
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    
    //Codigo boton agregar
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String producto = "";
        nombre = JOptionPane.showInputDialog(null, "Digite nombre del producto: ");
        producto += "Nombre: ";
        producto += nombre;
        producto += "\n";
        cantidad = JOptionPane.showInputDialog(null, "Digite cantidad: ");
        producto += "Cantidad: ";
        producto += cantidad;
        producto += "\n";
        precioU = JOptionPane.showInputDialog(null, "Digite el precio Unitario: ");
        producto += "Precio Unitario: ";
        producto += precioU;
        producto += "\n";
        codigo = JOptionPane.showInputDialog(null, "Digite el codigo: ");
        producto += "Codigo: ";
        producto += codigo;
        producto += "\n";
        categoria = JOptionPane.showInputDialog(null, "Digite nombre de la categoria: ");
        producto += "Categoria: ";
        producto += categoria;
        producto += "\n";
        nombres.add(nombre);
        codigos.add(codigo);
        mi_vector.add(producto);
    }                                       
    //Codigo boton buscar
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String opc;
        String buscar;
        opc = JOptionPane.showInputDialog(null, "Buscar por:\n1. nombre\n2. codigo identificador");
        boolean encontrado = false;
        if (opc.equals("1")) {
            buscar = JOptionPane.showInputDialog(null, "Ingrese nombre:");
            for (int i = 0; i < nombres.size(); i++) {
                if (buscar.equals(nombres.get(i))) {
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "El producto se encuentra en el inventario");
                    break;
                }
            }
        } else {
            buscar = JOptionPane.showInputDialog(null, "Ingrese codigo:");
            for (int i = 0; i < codigos.size(); i++) {
                if (buscar.equals(codigos.get(i))) {
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "El producto se encuentra en el inventario");
                    break;
                }
            }
        }

        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "El producto No se encuentra en el inventario");
        }

    }                                      
    //Codigo boton mostrar
    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        areaTexto.setText("");
        for (int i = 0; i < mi_vector.size(); i++) {
            areaTexto.append("-----------Producto "+(i+1)+"-----------\n");
            areaTexto.append((String) mi_vector.get(i)+"\n");
            
        }
    }                                       
    // COdigo boton borrar
    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String codigoBorrar, cantidad;
        codigoBorrar = JOptionPane.showInputDialog(null, "Ingrese codigo:");
        boolean encontrado = false;
        for (int i = 0; i < mi_vector.size(); i++) {
            if (codigoBorrar.equals(codigos.get(i))) {
                encontrado = true;
                cantidad = JOptionPane.showInputDialog(null, "Elemento Encontrado Ingrese cantidad:");
                mi_vector.removeElementAt(i);
                nombres.removeElementAt(i);
                codigos.removeElementAt(i);
                JOptionPane.showMessageDialog(null,"Elemento Borrado");
            }
        }
        if(encontrado == false){
            JOptionPane.showMessageDialog(null,"Elemento no ha si encontrado para borrar");
        }
    }                                      

    private javax.swing.JButton Borrar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton agregar;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostrar;
    
    
}
