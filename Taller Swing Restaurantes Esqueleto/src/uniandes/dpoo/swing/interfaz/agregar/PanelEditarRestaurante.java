package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    private JTextField txtNombre;
    private JComboBox<String> cbbCalificacion;
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        setLayout(new GridLayout(3, 1));

        // Nombre
        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNombre.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelNombre.add(txtNombre);
        add(panelNombre);

        // Calificación
        JPanel panelCalificacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCalificacion.add(new JLabel("Calificación (1-5):"));
        String[] calificaciones = {"1", "2", "3", "4", "5"};
        cbbCalificacion = new JComboBox<>(calificaciones);
        panelCalificacion.add(cbbCalificacion);
        add(panelCalificacion);

        // Visitado
        JPanel panelVisitado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelVisitado.add(new JLabel("¿Visitado?"));
        String[] opcionesVisitado = {"Sí", "No"};
        cbbVisitado = new JComboBox<>(opcionesVisitado);
        panelVisitado.add(cbbVisitado);
        add(panelVisitado);
    }

    public boolean fueVisitado()
    {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }

    public int getCalificacion()
    {
        String calif = (String) cbbCalificacion.getSelectedItem();
        return Integer.parseInt(calif);
    }

    public String getNombre()
    {
        return txtNombre.getText();
    }
}
