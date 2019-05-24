function sendFocusData(){
    console.log("hola");
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