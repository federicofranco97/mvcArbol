function sendFocus2(sth){
        var id=sth.id;
        if(id==0){
            swal({
                text: "No existen datos para esta persona!",
                icon: "error",
                dangerMode: true

              });
            
            
        }else{
            window.open("/focusPersona?id="+id,"_self");
        }   
        
}

function validarCamposStr2(){
        var list = document.getElementsByClassName("addMf");
        var check=true;
        var i=0;
        while (check) {
            if(list[i].value===null || list[i].value===" " || list[i].value===""){
                swal({
                    title: "Campo Incompleto!",
                    text:"El campo es: "+list[i].id,
                    icon: "error"
                  });
                list[i].focus();
                check=false;
            }
            i++;
            if(i===list.length)check=false;
        }   
}

function sendFocusData(sth){
    var id=sth.className;
    window.open("/focusPersona?id="+id,"_self");
}
    
function modificarPersona(sth){
    var id = sth.className;
    console.log(id);
    window.open("/modificar?id="+id,"_self");
}
    
function eliminarPersona(sth){
    var id = sth.parentNode.className;
    window.open("/eliminar?id="+id,"_self");
}


function secureDelete(){
        var quiereDelete=false;
        swal({
            title: "Esta seguro que quiere eliminar la persona?",
            text: "Una vez eliminada no se puede reestablecer!",
            icon: "warning",
            buttons: true,
            dangerMode: true
        })
        .then((willDelete) => {
            if (willDelete) {
                quiereDelete=true;
                swal("La persona se borro con exito!", {
                    icon: "success"
                });
                setTimeout("delayMove()",1000);
            } else {
                quiereDelete=false;
                swal("Borrar persona cancelado!",{icon:"error"});
                setTimeout("delayMove2()",1000);
            }
        });        
}
    
function delayMove(){
    document.getElementById("deletear").click();
}
    
function delayMove2(){
    document.getElementById("volver").click();
}


function validarCamposStr(){
    var list = document.getElementsByClassName("addIn");
    var check=true;
    var i=0;
    while (check) {
        if(list[i].value===null || list[i].value===" " || list[i].value===""){
        swal({
            title: "Campo Incompleto!",
            text:"El campo es: "+list[i].id,
            icon: "error"
        });
        list[i].focus();
        check=false;
        }
        i++;
        if(i===list.length)check=false;
    }           
}

function barFilter2() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("filtroTabla");
  filter = input.value.toUpperCase();
  table = document.getElementById("tablaPrincipal");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
    
  }
}

function barShow(){
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("filtroTabla");
    filter = input.value.toUpperCase();
    table = document.getElementById("tablaPrincipal");
    tr = table.getElementsByTagName("tr");
    if(filter==="" || filter===" " || filter ===null || filter.length===1){
        for (var i = 0; i < tr.length; i++) {
            tr[i].style.display="";
        }
        
  }
}