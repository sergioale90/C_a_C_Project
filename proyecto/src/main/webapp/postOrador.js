function enviarDatos() {
  event.preventDefault();
  const nombre = document.getElementById("Nombre").value;
  const apellido = document.getElementById("Apellido").value;
  const email = document.getElementById("email").value;
  const telefono = document.getElementById("Telefono").value;
  const tema = document.getElementById("Tema").value;
  fetch(
    `endpoint?nombreInput=${nombre}&apellidoInput=${apellido}&emailInput=${email}&telefonoInput=${telefono}&temaInput=${tema}`,
    { method: "POST" }
  )
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
    })
    .catch((err) => console.log(err));
  nombre.value = "";
  apellido.value = "";
  email.value = "";
  telefono.value = "";
  tema.value = "";
}
function mostrarMensaje(mensaje) {
  var mensajeDiv = document.createElement("div");
  mensajeDiv.textContent = mensaje;
  mensajeDiv.className = "mensaje";
  document.body.appendChild(mensajeDiv);
}
