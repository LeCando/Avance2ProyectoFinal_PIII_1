import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JTextField textField1nombreUsuario;
    private JTextField textField1idBanner;
    private JComboBox<String> comboBox1tipoPersona;
    private JTextField textField1placa;
    private JComboBox<String> comboBox2tipoAutomovil;
    private JButton agregarUsuarioButton;
    private JButton editarUsuarioButton;
    private JButton buscarButton;
    private JButton eliminarUsuarioButton;
    private JTextField textField1nompreParqueadero;
    private JTextField textField1espacioParqueadero;
    private JButton editarParqueaderoButton;
    private JButton agregarParqueaderoButton1;
    private JButton buscarParqueaderoButton;
    private JList list1;
    private JButton eliminarParqueaderoButton;
    private JList list2;
    private JTextField textField1idUsuarioPlaca;
    private JButton agregarVehiculosButton;
    private JButton eliminarVehiculosButton;
    private JTextField textField1placaeliminar;

    private Lista personas = new Lista();
    private ListaParqueadero parqueaderos = new ListaParqueadero();

    public Ventana() {
        quemarDatos();
        llenarJlistUsuarios();
        System.out.println(personas.listarPersonas());
        agregarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (textField1nombreUsuario.getText().isEmpty() ||
                            textField1idBanner.getText().isEmpty() ||
                            comboBox1tipoPersona.getSelectedItem() == null) {

                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        personas.adicionarElementos(new Persona(textField1nombreUsuario.getText(), textField1idBanner.getText(), comboBox1tipoPersona.getSelectedItem().toString()));
                        JOptionPane.showMessageDialog(null, "Se ha agreagado el usuario correctamente\n" +
                                "\nNombre: " + textField1nombreUsuario.getText() +
                                "\nID: " + textField1idBanner.getText() +
                                "\nTipo de persona: " + comboBox1tipoPersona.getSelectedItem().toString()
                        );
                        limpiarDatos();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                llenarJlistUsuarios();
                System.out.println(personas.listarPersonas());
            }
        });

        editarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField1nombreUsuario.getText().isEmpty() ||
                            textField1idBanner.getText().isEmpty() ||
                            comboBox1tipoPersona.getSelectedItem() == null) {

                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        personas.editar(
                                textField1nombreUsuario.getText(),
                                textField1idBanner.getText(),
                                comboBox1tipoPersona.getSelectedItem().toString()
                        );
                        JOptionPane.showMessageDialog(null, "Se ha modificado el usuario correctamente\n" +
                                "\nNombre: " + textField1nombreUsuario.getText() +
                                "\nID: " + textField1idBanner.getText() +
                                "\nTipo de persona: " + comboBox1tipoPersona.getSelectedItem().toString()
                        );

                        // Habilitar los campos para agregar otro usuario
                        textField1nombreUsuario.setEnabled(true);
                        textField1idBanner.setEnabled(true);
                        comboBox1tipoPersona.setEnabled(true);

                        // Limpia los campos después de editar al usuario
                        limpiarDatos();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                llenarJlistUsuarios();
                System.out.println(personas.listarPersonas());
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBuscar = textField1idBanner.getText();
                Persona persona = personas.buscarPersona(idBuscar);
                if (persona != null) {
                    textField1nombreUsuario.setText(persona.getNombre());
                    textField1nombreUsuario.setEnabled(false);
                    textField1idBanner.setEnabled(true);
                    comboBox1tipoPersona.setSelectedItem(persona.getTipoPersona());
                    comboBox1tipoPersona.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID de banner proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBuscar = textField1idBanner.getText();
                try {
                    personas.eliminarPersona(idBuscar);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                    limpiarDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                llenarJlistUsuarios();
            }
        });
        agregarParqueaderoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear un nuevo objeto Parqueadero con los datos ingresados
                    Parqueadero parqueadero = new Parqueadero(
                            textField1nompreParqueadero.getText(),
                            Integer.parseInt(textField1espacioParqueadero.getText())
                    );
                    parqueaderos.agregarParqueaderoP(parqueadero);

                    JOptionPane.showMessageDialog(null, "Se ha agregado el Parqueadero correctamente\n" +
                            "\nNombre del Parqueadero: " + textField1nompreParqueadero.getText() +
                            "\nEspacio del parqueadero: " + Integer.parseInt(textField1espacioParqueadero.getText()));
                    limpiarDatosParqueadero();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar parqueadero: " + ex.getMessage());
                }
                llenarJlistParqueaderos();
                System.out.println(parqueaderos.listarParqueadero());
            }
        });
        editarParqueaderoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    parqueaderos.editarParqueadero(textField1nompreParqueadero.getText(), Integer.parseInt(textField1espacioParqueadero.getText()));
                    JOptionPane.showMessageDialog(null, "Se ha agregado el Parqueadero correctamente\n" +
                            "\nNombre del Parqueadero: " + textField1nompreParqueadero.getText() +
                            "\nEspacio del parqueadero: " + Integer.parseInt(textField1espacioParqueadero.getText()));
                    System.out.println(parqueaderos.listarParqueadero());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar el campo " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                llenarJlistParqueaderos();
            }
        });
        buscarParqueaderoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1nompreParqueadero.getText();
                Parqueadero parqueadero = parqueaderos.buscarParqeuadero(nombre);
                if (parqueadero != null) {
                    textField1nompreParqueadero.setEnabled(true);
                    textField1espacioParqueadero.setText(String.valueOf(parqueadero.getCantidadEspacio()));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID de banner proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        eliminarParqueaderoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscarLugar = textField1nompreParqueadero.getText();
                try {
                    parqueaderos.eliminarParqueadero(buscarLugar);
                    JOptionPane.showMessageDialog(null, "Parqueadero eliminado correctamente.");
                    limpiarDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar parqueadero: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                llenarJlistParqueaderos();
            }
        });
        agregarVehiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idPersona = textField1idUsuarioPlaca.getText();
                    String placa = textField1placa.getText();
                    String tipoVehiculo = comboBox2tipoAutomovil.getSelectedItem().toString();

                    // Verificar si el ID de la persona está vacío
                    if (idPersona.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El campo ID de Persona está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Buscar la persona en la lista utilizando el ID proporcionado
                    Persona persona = personas.buscarPersona(idPersona);

                    // Verificar si se encontró la persona
                    if (persona != null) {
                        // Verificar si la persona ya tiene dos vehículos
                        if (persona.getVehiculos().size() >= 2) {
                            throw new Exception("El límite por persona es dos vehículos.");
                        }

                        // Crear el vehículo
                        Vehiculo vehiculo = new Vehiculo(placa, tipoVehiculo);

                        // Agregar el vehículo a la persona encontrada
                        persona.addVehiculo(vehiculo);

                        JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente a la persona con ID: " + idPersona);

                        // Limpiar los campos después de agregar el vehículo
                        textField1placa.setText("");
                        comboBox2tipoAutomovil.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar vehículo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        eliminarVehiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = textField1placaeliminar.getText();
                try {
                    personas.eliminarVehiculoPorPlaca(placa);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el vehículo con la placa: " + placa);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar vehículo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
        public void limpiarDatos(){
        textField1nombreUsuario.setText("");
        textField1idBanner.setText("");
        comboBox1tipoPersona.setSelectedIndex(0);
        textField1placa.setText("");
        comboBox2tipoAutomovil.setSelectedIndex(0);
    }
    public void limpiarDatosParqueadero(){
        textField1nompreParqueadero.setText("");
        textField1espacioParqueadero.setText("");
    }
    public void quemarDatos() {
        try {
            personas.adicionarElementos(new Persona("Israel", "A00107465", "Estudiante"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void llenarJlistUsuarios(){
        DefaultListModel dl = new DefaultListModel<>();
        for(Persona p:personas.getPersonas()){
            dl.addElement(p);
        }
        list1.setModel(dl);
    }
    public void llenarJlistParqueaderos(){
        DefaultListModel dl = new DefaultListModel<>();
        for(Parqueadero pa:parqueaderos.getParqueaderos()){
            dl.addElement(pa);
        }
        list2.setModel(dl);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
