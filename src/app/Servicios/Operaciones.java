package app.Servicios;

import app.DTOs.PersonaDTO;
import app.Models.Persona;
import app.Repository.PersonaRepository;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Operaciones {
    
    public Operaciones(){
        generarFamiliaPrueba();
        llenarPaises();
    }
    @Autowired
    private PersonaRepository perRepo;
    
    private ArrayList<Persona>lista= new ArrayList<Persona>();
    private ArrayList<PersonaDTO> aux = new ArrayList<>();
    private ArrayList<String> paisesNatal = new ArrayList<>();
    private ArrayList<String> paisesVive = new ArrayList<>();
    
    public ArrayList<PersonaDTO> getLista() {
       return aux;
    }
    public ArrayList<String> getPaisVive(){
        return paisesVive;
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
    
    public void llenarPaises(){
        paisesVive.addAll(Arrays.asList("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"));
        paisesNatal.addAll(Arrays.asList("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"));
        
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
        lista.addAll(Arrays.asList(bisa,bisa2,bisa3,bisa4,abue,abue2,abue3,abue4,papa,papa2,tio,tio2,tio3,hijo));
        for (Persona persona : lista) {
            aux.add(new PersonaDTO(persona.getNombre(),persona.getApellido(), persona.getGenero(),persona.getId()));      
        }
        setearIdsPersona(lista);
        setearIdsPersonaDTO(aux);
        for (PersonaDTO personaDTO : aux) {
            personaDTO.setPaisNatal("Argentina");
            personaDTO.setPaisVive("Venezuela");
            personaDTO.setFechaNac("1989-04-24");
            personaDTO.setDomicilio("Calle falsa 123");
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
        }else{
            return null;
        }
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
