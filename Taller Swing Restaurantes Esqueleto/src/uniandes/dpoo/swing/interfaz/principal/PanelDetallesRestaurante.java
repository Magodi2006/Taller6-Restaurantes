package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel {
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante() {
        setLayout(new GridLayout(3, 1));

        // Etiqueta para el nombre
        labNombre = new JLabel("Nombre: ");
        add(labNombre);

        // Etiqueta para la calificación con estrellas
        labCalificacion = new JLabel(new ImageIcon("./imagenes/stars0.png")); // Imagen por defecto
        add(labCalificacion);

        // Checkbox para indicar si fue visitado
        chkVisitado = new JCheckBox("Visitado");
        chkVisitado.setEnabled(false);
        add(chkVisitado);
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     */
    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado) {
        labNombre.setText("Nombre: " + nombre);
        labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
        chkVisitado.setSelected(visitado);
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     */
    public void actualizarRestaurante(Restaurante r) {
        this.actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
    }

    /**
     * Dada una calificación, retorna una imagen para utilizar en la etiqueta que muestra la calificación
     */
    private ImageIcon buscarIconoCalificacion(int calificacion) {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon(imagen);
    }
}

