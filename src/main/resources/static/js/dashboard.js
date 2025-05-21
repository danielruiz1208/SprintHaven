// Script para manejar la navegación y la barra lateral en el dashboard
document.addEventListener('DOMContentLoaded', function() {
    // Maneja la navegación entre secciones
    const navLinks = document.querySelectorAll('.nav-menu a');
    const sections = document.querySelectorAll('.section');

    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const targetSection = this.getAttribute('href').substring(1);

            // Actualiza los enlaces activos
            navLinks.forEach(link => link.classList.remove('active'));
            this.classList.add('active');

            // Muestra la sección correspondiente
            sections.forEach(section => {
                section.classList.remove('active');
                if (section.id === targetSection) {
                    section.classList.add('active');
                }
            });
        });
    });

    // Maneja el colapso/expansión de la barra lateral
    const sidebar = document.getElementById('sidebar');
    const mainContent = document.querySelector('.main-content');
    const logoToggle = document.getElementById('logo-toggle');

    logoToggle.addEventListener('click', function() {
        sidebar.classList.toggle('collapsed');
        mainContent.classList.toggle('collapsed');
    });

    // Muestra la sección de usuarios por defecto
    document.getElementById('usuarios').classList.add('active');
});