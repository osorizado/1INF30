package softpubpersonatest;

import pe.edu.pucp.softpub.persona.bo.SeccionBO;

public class SoftPubPersonaTest {

    public static void main(String[] args) {
       SeccionBO seccionBO = new SeccionBO();
       seccionBO.insertar("INF", "Informática", "Ingeniería");
       seccionBO.insertar("TEL", "Telecomunicaciones", "Ingeniería");
    }
    
}
