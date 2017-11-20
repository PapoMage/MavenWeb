$(document).ready(function(){
  $('.modal').modal();
  $(".button-collapse").sideNav();

});

function openModal(id) {
  $('#modal'+id).modal('open');
}
function commentSuccesful(id) {
  $('#modal'+id).modal('close');
    Materialize.toast('Se ha creado tu comentario', 8000);
}
function postSuccesful() {
  if($('.content-post').val() != "")
  Materialize.toast('Se ha creado tu post', 8000);
}

if ($('#alerts ul').length) {
  swal("Error en el registro", $('#alerts ul li').text(), "error");
}
