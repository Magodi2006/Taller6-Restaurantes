package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame {

    private PanelEditarRestaurante panelDetalles;
    private PanelBotonesAgregar panelBotones;
    private PanelMapaAgregar panelMapa;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante(VentanaPrincipal principal) {
        this.ventanaPrincipal = principal;
        setLayout(new BorderLayout());

        // Mapa al centro
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Panel inferior con detalles y botones
        JPanel panelSur = new JPanel(new GridLayout(1, 2));
        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this); // Pasa esta ventana como referencia
        panelSur.add(panelDetalles);
        panelSur.add(panelBotones);
        add(panelSur, BorderLayout.SOUTH);

        // Configuración de la ventana
        setTitle("Agregar Nuevo Restaurante");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Recolecta datos y crea un nuevo restaurante desde VentanaPrincipal
     */
    public void agregarRestaurante() {
        String nombre = panelDetalles.getNombre();
        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.fueVisitado();
        int x = panelMapa.getPosicionX();
        int y = panelMapa.getPosicionY();

        ventanaPrincipal.agregarRestaurante(nombre, calificacion, x, y, visitado);
        dispose(); // cerrar la ventana luego de agregar
    }

    /**
     * Cierra la ventana sin hacer nada
     */
    public void cerrarVentana() {
        dispose();
    }
}

