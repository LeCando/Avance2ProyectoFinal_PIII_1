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

    private Lista personas = new Lista();
    private ListaParqueadero parqueaderos = new ListaParqueadero();

    public Ventana() {
        quemarDatos();
        System.out.println(personas.listarPersonas());
        agregarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (textField1nombreUsuario.getText().isEmpty() ||
                            textField1idBanner.getText().isEmpty() ||
                            comboBox1tipoPersona.getSelectedItem() == null ||
                            textField1placa.getText().isEmpty() ||
                            comboBox2tipoAutomovil.getSelectedItem() == null) {

                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        personas.adicionarElementos(new Persona(textField1nombreUsuario.getText(), textField1idBanner.getText(), comboBox1tipoPersona.getSelectedItem().toString(), new Vehiculo(textField1placa.getText(), comboBox2tipoAutomovil.getSelectedItem().toString())
                        ));
                        JOptionPane.showMessageDialog(null, "Se ha agreagado el usuario correctamente\n"+
                                "\nNombre: " + textField1nombreUsuario.getText() +
                                "\nID: " + textField1idBanner.getText() +
                                "\nTipo de persona: " + comboBox1tipoPersona.getSelectedItem().toString() +
                                "\nPlaca: " + textField1placa.getText() +
                                "\nTipo de vehiculo: " + comboBox2tipoAutomovil.getSelectedItem().toString()
                        );

                        limpiarDatos();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(personas.listarPersonas());
            }
        });

        editarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField1nombreUsuario.getText().isEmpty() ||
                            textField1idBanner.getText().isEmpty() ||
                            comboBox1tipoPersona.getSelectedItem() == null ||
                            textField1placa.getText().isEmpty() ||
                            comboBox2tipoAutomovil.getSelectedItem() == null) {

                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        personas.editar(
                                textField1nombreUsuario.getText(),
                                textField1idBanner.getText(),
                                comboBox1tipoPersona.getSelectedItem().toString(),
                                new Vehiculo(
                                        textField1placa.getText(),
                                        comboBox2tipoAutomovil.getSelectedItem().toString()
                                ),
                                new Vehiculo(
                                        textField1placa.getText(),
                                        comboBox2tipoAutomovil.getSelectedItem().toString()
                                )
                        );
                        JOptionPane.showMessageDialog(null, "Se ha modificado el usuario correctamente\n" +
                                "\nNombre: " + textField1nombreUsuario.getText() +
                                "\nID: " + textField1idBanner.getText() +
                                "\nTipo de persona: " + comboBox1tipoPersona.getSelectedItem().toString() +
                                "\nPlaca: " + textField1placa.getText() +
                                "\nTipo de vehículo: " + comboBox2tipoAutomovil.getSelectedItem().toString()
                        );

                        // Habilitar los campos para agregar otro usuario
                        textField1nombreUsuario.setEnabled(true);
                        textField1idBanner.setEnabled(true);
                        comboBox1tipoPersona.setEnabled(true);
                        textField1placa.setEnabled(true);
                        comboBox2tipoAutomovil.setEnabled(true);

                        // Limpia los campos después de editar al usuario
                        limpiarDatos();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
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
                        comboBox1tipoPersona.setEnabled(false);
                        textField1placa.setText(persona.getVehiculo().getPlaca());
                        comboBox2tipoAutomovil.setSelectedItem(persona.getVehiculo().getTipoVehiculo());
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
                System.out.println(parqueaderos.listarParqueadero());
            }
        });
        editarParqueaderoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try{
                parqueaderos.editarParqueadero(textField1nompreParqueadero.getText(),Integer.parseInt(textField1espacioParqueadero.getText()));
                JOptionPane.showMessageDialog(null, "Se ha agregado el Parqueadero correctamente\n" +
                        "\nNombre del Parqueadero: " + textField1nompreParqueadero.getText() +
                        "\nEspacio del parqueadero: " + Integer.parseInt(textField1espacioParqueadero.getText()));
                System.out.println(parqueaderos.listarParqueadero());
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Error al modificar el campo " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        buscarParqueaderoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1nompreParqueadero.getText();
                Parqueadero parqueadero = parqueaderos.buscarParqeuadero(nombre);
                if (parqueadero != null) {
                    textField1nompreParqueadero.setEnabled(false);
                    textField1espacioParqueadero.setText(String.valueOf(parqueadero.getCantidadEspacio()));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID de banner proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
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
            personas.adicionarElementos(new Persona("Israel", "A00107465", "Estudiante", new Vehiculo("PCX3903","Automovil")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
