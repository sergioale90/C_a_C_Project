function enviarDatos() {
  event.preventDefault();
  const nombre = document.getElementById("Nombre").value;
  const apellido = document.getElementById("Apellido").value;
  const email = document.getElementById("email").value;
  const telefono = document.getElementById("Telefono").value;
  const tema = document.getElementById("Tema").value;
  fetch(
    `src/main/java/controlador/Controlador?nombre=${nombre}&apellido=${apellido}&email=${email}&telefono=${telefono}&tema=${tema}`,
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
