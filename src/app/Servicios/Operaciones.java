package app.Servicios;

import app.DTOs.PersonaDTO;
import app.Models.Consulta;
import app.Models.EdadModel;
import app.Models.Persona;
import app.Models.Seteo;
import app.Repository.PersonaRepository;
import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Operaciones {
    
    public Operaciones(){
        generarFamiliaPrueba();
        llenarPaises();
        llenarConsultas();
        llenarListaComandos();
        calcularPromediosM();
    }
    @Autowired
    private PersonaRepository perRepo;
    
    private ArrayList<Persona>lista= new ArrayList<Persona>();
    private ArrayList<PersonaDTO> aux = new ArrayList<>();
    private ArrayList<String> paisesNatal = new ArrayList<>();
    private ArrayList<String> paisesVive = new ArrayList<>();
    private ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ArrayList<Seteo> listaComandos = new ArrayList<>();
    private ArrayList<Integer> listaRangos = new ArrayList<>();

    public ArrayList<Integer> getListaRangos() {
        return listaRangos;
    }

    public void setListaRangos(ArrayList<Integer> listaRangos) {
        this.listaRangos = listaRangos;
    }
    
    public ArrayList<PersonaDTO> getLista() {
       return aux;
    }
    public ArrayList<String> getPaisVive(){
        return paisesVive;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public ArrayList<Seteo> getListaComandos() {
        return listaComandos;
    }

    public void setListaComandos(ArrayList<Seteo> listaComandos) {
        this.listaComandos = listaComandos;
    }
    
    public void llenarListaComandos(){
        listaComandos.add(new Seteo("setPadre", "Setear como padre a"));
        listaComandos.add(new Seteo("setMadre", "Setear como madre a"));
        listaComandos.add(new Seteo("setHijo", "Setear como hijo/a a"));
    }
    
    public void setearPadre(PersonaDTO personaDTO,long id){
        Persona setear=buscarPorId(personaDTO.getId());
        Persona seteado=buscarPorId(id);
        setear.setPadre(seteado);
    }
    
    public void setearMadre(PersonaDTO personaDTO,long id){
        Persona setear=buscarPorId(personaDTO.getId());
        Persona seteado=buscarPorId(id);
        setear.setMadre(seteado);
    }
    
    public void agregarHijo(PersonaDTO personaDTO,long id){
        Persona setear=buscarPorId(personaDTO.getId());
        Persona seteado=buscarPorId(id);
        setear.addHijo(seteado);
    }
    
    public ArrayList<PersonaDTO> getHijosDTO(PersonaDTO personaDTO){
        Persona aux=buscarPorId(personaDTO.getId());
        ArrayList<Persona> list = aux.getHijos();
        ArrayList<PersonaDTO> list2 = new ArrayList<>();
        for (Persona persona : list) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            list2.add(aux2);
        }
        return list2;
    }
    
    public void calcularPromediosM(){
        for (PersonaDTO personaDTO : aux) {
            asignarRango(personaDTO);
        }
    }
    
    public void asignarRango(PersonaDTO personaDTO){
        //boolean true es inmigrante
        boolean aux=true;
        if(personaDTO.getPaisNatal().equals(personaDTO.getPaisVive()))aux=false;
        int edad=(int) calcularEdad(personaDTO);
        if(aux)listaRangos.add((edad));  
    }
    
    public long calcularEdad(PersonaDTO personaDTO){
        Date hoy=new Date(2019, 6, 13);
        String [] list=personaDTO.getFechaNac().split("-");
        Date birth=new Date(Integer.parseInt(list[0]),Integer.parseInt(list[1]),Integer.parseInt(list[2]));
        long diffInMillies = Math.abs(birth.getTime() - hoy.getTime());
        long diff = (TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS))/365;
        return diff;
    }
    
    public ArrayList<PersonaDTO> getHermanosDTO(PersonaDTO personaDTO){
        Persona aux=buscarPorId(personaDTO.getId()).getPadre();
        Persona aux3=buscarPorId(personaDTO.getId()).getMadre();
        ArrayList<Persona> list = aux.getHijos();
        ArrayList<Persona> list3 = aux3.getHijos();
        ArrayList<PersonaDTO> list2 = new ArrayList<>();
        for (Persona persona : list) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            
        }
        for (Persona persona : list3) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            
            if(list2.indexOf(aux2)==-1){
                list2.add(aux2);
            }
            
        }
        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).getId() == personaDTO.getId())list2.remove(i);
        }
        return list2;
    }
    
    public ArrayList<PersonaDTO> getTiosDTO(PersonaDTO personaDTO){
        Persona aux=buscarPorId(personaDTO.getId()).getPadre().getPadre();
        Persona aux3=buscarPorId(personaDTO.getId()).getPadre().getMadre();
        Persona aux4=buscarPorId(personaDTO.getId()).getMadre().getMadre();
        Persona aux5=buscarPorId(personaDTO.getId()).getMadre().getPadre();
        ArrayList<Persona> list = aux.getHijos();
        ArrayList<Persona> list3 = aux3.getHijos();
        ArrayList<Persona> list4 = aux4.getHijos();
        ArrayList<Persona> list5 = aux5.getHijos();
        ArrayList<PersonaDTO> list2 = new ArrayList<>();
        if(aux ==null || aux3 == null){
            return list2;
        }
        for (Persona persona : list) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            list2.add(aux2);
            
        }
        for (Persona persona : list3) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            if(!existe(list2, aux2)){
                list2.add(aux2);
            }
        }
        for (Persona persona : list4) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            if(!existe(list2, aux2)){
                list2.add(aux2);
            }
        }
        for (Persona persona : list5) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            if(!existe(list2, aux2)){
                list2.add(aux2);
            }
        }
        int idPad=(int)getPadreDTO(personaDTO).getId();
        int idMad=(int)getMadreDTO(personaDTO).getId();
        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).getId() == idPad || list2.get(i).getId() == idMad)list2.remove(i);
        }
        return list2;
    }
    
    public boolean existe(ArrayList<PersonaDTO> list,PersonaDTO personaDTO){
        for (PersonaDTO dto : list) {
            if(dto.getId() == personaDTO.getId())return true;
        }
        return false;
    }
    
    public ArrayList<PersonaDTO> getAbuelosDTO(PersonaDTO personaDTO){
        Persona aux=buscarPorId(personaDTO.getId()).getPadre().getPadre();
        Persona aux2=buscarPorId(personaDTO.getId()).getPadre().getMadre();
        Persona aux3=buscarPorId(personaDTO.getId()).getMadre().getPadre();
        Persona aux4=buscarPorId(personaDTO.getId()).getMadre().getMadre();
        ArrayList<PersonaDTO> list = new ArrayList<>();
        ArrayList<Persona> listAux = new ArrayList<>();
        listAux.addAll(Arrays.asList(aux,aux2,aux3,aux4));
        for (Persona persona : listAux) {
            PersonaDTO dto = new PersonaDTO();
            dto.convertir(persona);
            list.add(dto);
        }
        return list;
    }
    
    public ArrayList<PersonaDTO> getPrimosDTO(PersonaDTO personaDTO){
        Persona aux=buscarPorId(personaDTO.getId()).getPadre().getPadre();
        Persona aux3=buscarPorId(personaDTO.getId()).getPadre().getMadre();
        Persona aux4=buscarPorId(personaDTO.getId()).getMadre().getMadre();
        Persona aux5=buscarPorId(personaDTO.getId()).getMadre().getPadre();
        ArrayList<Persona> list = aux.getHijos();
        ArrayList<Persona> list3 = aux3.getHijos();
        ArrayList<Persona> list4 = aux4.getHijos();
        ArrayList<Persona> list5 = aux5.getHijos();
        ArrayList<PersonaDTO> list2 = new ArrayList<>();
        if(aux ==null || aux3 == null){
            return list2;
        }
        for (Persona persona : list) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            list2.add(aux2);
            
        }
        for (Persona persona : list3) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            if(!existe(list2, aux2)){
                list2.add(aux2);
            }
        }
        for (Persona persona : list4) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            if(!existe(list2, aux2)){
                list2.add(aux2);
            }
        }
        for (Persona persona : list5) {
            PersonaDTO aux2 = new PersonaDTO();
            aux2.convertir(persona);
            if(!existe(list2, aux2)){
                list2.add(aux2);
            }
        }
        int idPad=(int)getPadreDTO(personaDTO).getId();
        int idMad=(int)getMadreDTO(personaDTO).getId();
        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).getId() == idPad || list2.get(i).getId() == idMad)list2.remove(i);
        }
        ArrayList<PersonaDTO> listPrimos = new ArrayList<>();
        for (PersonaDTO dto : list2) {
            ArrayList<Persona>listHijos=buscarPorId(dto.getId()).getHijos();
            for (Persona hijo : listHijos) {
                PersonaDTO kk = new PersonaDTO();
                kk.convertir(hijo);
                if(!existe(listPrimos, kk))listPrimos.add(kk);
            }
        }
        return listPrimos;
    }
    
    public void llenarConsultas(){
        listaConsultas.add(new Consulta("getHijos", "Traer hijos"));
        listaConsultas.add(new Consulta("getHermanos", "Traer hermanos"));
        listaConsultas.add(new Consulta("getTios", "Traer Tios"));
        listaConsultas.add(new Consulta("getAbuelos", "Traer Abuelos"));
        listaConsultas.add(new Consulta("getPrimos", "Traer Primos"));
        
    }
    public String generarFechaRandom(){
        int año = (int)(Math.random()* 89) + 1930;
        int mes = (int)(Math.random()* 12) + 1;
        int dia = (int)(Math.random()* 20) + 1 ;
        String aux= año + "-" + mes + "-" + dia;
        if(mes>10 && dia >10){
            aux = año + "-" + mes + "-" + dia;
        }
        if(mes>10 && dia <10){
            aux = año + "-" + mes + "-0" + dia;
        }
        if(mes<10 && dia >10){
            aux = año + "-0" + mes + "-" + dia;
        }
        if(mes<10 && dia <10){
            aux = año + "-0" + mes + "-0" + dia;   
        }
        return aux;
    }
    
    public void agregarPaisVive(String pais){
        paisesVive.add(0,pais);
    }
    public ArrayList<String> getPaisNatal(){
        return paisesNatal;
    }
    
    public void agregarPaisNatal(String pais){
        paisesNatal.add(0,pais);
    }
    
    public void borrarPersonaDTO(long id){
        int pos=(int)id;
        aux.remove(pos);
        lista.remove(pos);
    }
    
    public void llenarPaises(){
        paisesVive.addAll(Arrays.asList("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
                "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", 
                "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina",
                "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
                "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", 
                "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", 
                "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the",
                "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic",
                "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", 
                "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)",
                "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", 
                "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany",
                "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", 
                "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands",
                "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
                "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
                "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", 
                "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia",
                "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", 
                "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi",
                "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
                "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia",
                "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", 
                "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue",
                "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", 
                "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico",
                "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
                "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia",
                "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", 
                "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain",
                "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", 
                "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
                "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", 
                "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", 
                "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", 
                "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
                "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
                "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"));
        paisesNatal.addAll(Arrays.asList("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
                "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", 
                "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina",
                "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
                "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", 
                "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", 
                "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the",
                "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic",
                "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", 
                "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)",
                "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", 
                "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany",
                "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", 
                "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands",
                "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
                "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
                "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", 
                "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia",
                "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", 
                "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi",
                "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
                "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia",
                "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", 
                "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue",
                "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", 
                "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico",
                "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
                "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia",
                "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", 
                "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain",
                "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", 
                "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
                "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", 
                "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", 
                "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", 
                "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
                "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
                "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"));
        
    }
    
    public void actualizarPersona(PersonaDTO personaDTO){       
        aux.get((int)personaDTO.getId()).actualizar(personaDTO);
        lista.get((int)personaDTO.getId()).actualizar(personaDTO);         
    }
        
    public void agregarPersona(PersonaDTO personaDTO){
        aux.add(personaDTO);
        Persona persona = new Persona(personaDTO.getNombre(), personaDTO.getApellido(), personaDTO.getApellido());
        lista.add(persona);
        setearIdsPersona(lista);
        setearIdsPersonaDTO(aux);
    }
    
    //En el constructor, cuando creo una persona que tiene padre, al padre setearle
    //la persona como hijo.
    public ArrayList<PersonaDTO> generarFamiliaPrueba(){
        
        //bisabuelos
        Persona bisa = new Persona("Don Carlos","Espinoza","m");
        Persona bisa2 = new Persona("Esmeralda","Lopez","f");
        Persona bisa3 = new Persona("Miguel","Maritinez","m");
        Persona bisa4 = new Persona("Rosa","Acasusso","f");
        //abuelos
        Persona abue = new Persona("Manuel","Espinoza", bisa, bisa2,"m");
        Persona abue2 = new Persona("Gilda","Martinez",bisa3,bisa4,"f");
        Persona abue3 = new Persona("Marcos","Martinez",bisa3,bisa4,"m");
        Persona abue4 = new Persona("Estela","Martinez",bisa3,bisa4,"f");
        //seteo abuelos como hijos de los bisa
        bisa.addHijo(abue);
        bisa2.addHijo(abue);
        bisa3.addHijo(abue2);
        bisa4.addHijo(abue2);
        //Creo papas
        Persona papa = new Persona("Jorge","Espinoza",abue,abue2,"m");
        Persona papa2 = new Persona("Maria","Martinez",abue3,abue4,"f");
        //Creo tios
        Persona tio = new Persona("Fernando","Espinoza",abue,abue2,"m");
        Persona tio2 = new Persona("Tomas","Espinoza",abue,abue2,"m");
        Persona tio3 = new Persona("Agustina","Espinoza",abue,abue2,"f");
        //Agrego hijos a los abuelos
        abue.addHijos(Arrays.asList(papa,tio, tio2, tio3));
        abue2.addHijos(Arrays.asList(papa,tio, tio2, tio3));
        //Creo los hijos
        Persona hijo = new Persona("Martin","Espinoza",papa,papa2,"m");
        Persona hijo2 = new Persona("Carlitos","Espinoza",tio,tio2,"m");
        tio.addHijo(hijo2);
        tio2.addHijo(hijo2);
        papa.addHijo(hijo);
        papa2.addHijo(hijo);
        lista.addAll(Arrays.asList(bisa,bisa2,bisa3,bisa4,abue,abue2,abue3,abue4,papa,papa2,tio,tio2,tio3,hijo,hijo2));
        for (Persona persona : lista) {
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.convertir(persona);
            aux.add(personaDTO);
        }
        setearIdsPersona(lista);
        setearIdsPersonaDTO(aux);
        for (PersonaDTO personaDTO : aux) {
            personaDTO.setPaisNatal("Argentina");
            personaDTO.setPaisVive("Venezuela");
            personaDTO.setFechaNac(generarFechaRandom());
            personaDTO.setDomicilio("Calle falsa 123");
            lista.get((int)personaDTO.getId()).actualizar(personaDTO);
        }
        
        return aux;        
    }
    
    public void setearIdsPersona(ArrayList<Persona> list){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i);
        }
    }
      
    public void setearIdsPersonaDTO(ArrayList<PersonaDTO> list){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i);
        }
    }
    
    public PersonaDTO getPadreDTO(PersonaDTO personaDTO){
        Persona modelPersona = buscarPorId(personaDTO.getId());
        if(modelPersona.getPadre()!=null){
            return new PersonaDTO(modelPersona.getPadre().getNombre(),
                    modelPersona.getPadre().getApellido(), modelPersona.getPadre().getGenero(),modelPersona.getPadre().getId());
        }else{
            return null;
        }
    }
    
    public PersonaDTO getMadreDTO(PersonaDTO personaDTO){
        Persona modelPersona = buscarPorId(personaDTO.getId());
        if(modelPersona.getMadre()!=null){
            return new PersonaDTO(modelPersona.getMadre().getNombre(),
                    modelPersona.getMadre().getApellido(), modelPersona.getMadre().getGenero(),modelPersona.getMadre().getId());
        }
        return null;
    }
    
    public PersonaDTO buscarIdDTO(long id){
        for (PersonaDTO personaDTO : aux) {
            if(personaDTO.getId()==id) return personaDTO;
        }
        return null;
    }
    
    public PersonaDTO buscarNombreDTO(String nombre){
        for (PersonaDTO personaDTO : aux) {
            if(personaDTO.getNombre().equals(nombre)) return personaDTO;
        }
        return null;
        
    }
    
    public Persona buscarNombre(String nombre){
        for (Persona persona : lista) {
            if(persona.getNombre().equals(nombre))return persona;
        }
        return null;
    }
    
    public Persona buscarPorId(long id){
        for (Persona persona : lista) {
            if(persona.getId()==id)return persona;
        }
        return null;
    }
    
}
