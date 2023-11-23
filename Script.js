document.addEventListener('DOMContentLoaded', function() {
    const calcularbutton = document.getElementById('calcular');
    const categoriaSelect = document.getElementById('categoria');
    const cantidadInput = document.getElementById('cantidad');
    const form = document.getElementById('form');
    const buttonBorrar = document.getElementById('buttonBorrar');
    const totalSpan = document.getElementById('total');
      
  
    calcularbutton.addEventListener('click', function() {
      const categoria = categoriaSelect.value;
      const cantidad = parseInt(cantidadInput.value, 10);
  
      let descuento = 0;
  
      if (categoria === 'estudiante') {
        descuento = 0.8; // 80% de descuento para estudiantes
      } else if (categoria === 'trainee') {
        descuento = 0.5; // 50% de descuento para trainees
      } else if (categoria === 'junior') {
        descuento = 0.15; // 15% de descuento para juniors
      }
  
      const precioPorTicket = 200; // Precio por ticket
      const total = cantidad * precioPorTicket * (1 - descuento); // Calcula el total a pagar
  
      totalSpan.textContent = total.toFixed(2); // Muestra el resultado en la página
    });
    buttonBorrar.addEventListener('click', function() {
        form.reset(); // Esto borrará los datos del formulario
        totalSpan.textContent = '0'; // También restablecemos el total
  });
});