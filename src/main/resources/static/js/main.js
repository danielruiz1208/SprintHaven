// Script para manejar el cambio entre formularios de login y registro
document.addEventListener('DOMContentLoaded', () => {
    const container = document.querySelector('.container');
    const registerBtn = document.querySelector('.register-btn');
    const loginBtn = document.querySelector('.login-btn');

    // Verifica que los elementos existan
    if (!container || !registerBtn || !loginBtn) {
        console.error('No se encontraron los elementos necesarios en el DOM');
        return;
    }

    // Muestra el formulario de registro
    registerBtn.addEventListener('click', () => {
        container.classList.add('active');
    });

    // Muestra el formulario de login
    loginBtn.addEventListener('click', () => {
        container.classList.remove('active');
    });

    // Muestra el formulario de registro si hay un error
    const showRegister = /*[[${showRegister}]]*/ false;
    if (showRegister) {
        container.classList.add('active');
    }
});