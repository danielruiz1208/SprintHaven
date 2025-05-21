// Script para manejar modales y eventos en las secciones de gestión
document.addEventListener('DOMContentLoaded', () => {
    // Función para abrir el modal de personas
    function openPersonaModal(mode, ru = null, nombre = '', apellidoPaterno = '', apellidoMaterno = '', correo = '', telefono = '', fechaNacimiento = '') {
        const modal = document.getElementById('personaModal');
        const form = document.getElementById('personaForm');
        const modalTitle = document.getElementById('personaModalTitle');
        const ruInput = document.getElementById('personaRu');
        const nombreInput = document.getElementById('personaNombre');
        const apellidoPaternoInput = document.getElementById('personaApellidoPaterno');
        const apellidoMaternoInput = document.getElementById('personaApellidoMaterno');
        const correoInput = document.getElementById('personaCorreo');
        const telefonoInput = document.getElementById('personaTelefono');
        const fechaNacimientoInput = document.getElementById('personaFechaNacimiento');

        if (modal) {
            if (mode === 'add') {
                modalTitle.textContent = 'Agregar Persona';
                form.action = '/personas/add';
                ruInput.value = '';
                nombreInput.value = '';
                apellidoPaternoInput.value = '';
                apellidoMaternoInput.value = '';
                correoInput.value = '';
                telefonoInput.value = '';
                fechaNacimientoInput.value = '';
            } else if (mode === 'edit') {
                modalTitle.textContent = 'Editar Persona';
                form.action = '/personas/update';
                ruInput.value = ru || '';
                nombreInput.value = nombre || '';
                apellidoPaternoInput.value = apellidoPaterno || '';
                apellidoMaternoInput.value = apellidoMaterno || '';
                correoInput.value = correo || '';
                telefonoInput.value = telefono || '';
                fechaNacimientoInput.value = fechaNacimiento || '';
            }
            modal.style.display = 'flex';
        }
    }

    // Función para abrir el modal de préstamos
    function openPrestamoModal(mode, id = null, idUsuario = '', idLaboratorio = '', idAdministrador = '', fechaSolicitud = '', fechaPrestamo = '', fechaDevolucionEstimada = '', estado = '', observaciones = '') {
        const modal = document.getElementById('prestamoModal');
        const form = document.getElementById('prestamoForm');
        const modalTitle = document.getElementById('prestamoModalTitle');
        const idInput = document.getElementById('prestamoId');
        const idUsuarioInput = document.getElementById('prestamoIdUsuario');
        const idLaboratorioInput = document.getElementById('prestamoIdLaboratorio');
        const idAdministradorInput = document.getElementById('prestamoIdAdministrador');
        const fechaSolicitudInput = document.getElementById('prestamoFechaSolicitud');
        const fechaPrestamoInput = document.getElementById('prestamoFechaPrestamo');
        const fechaDevolucionEstimadaInput = document.getElementById('prestamoFechaDevolucionEstimada');
        const estadoInput = document.getElementById('prestamoEstado');
        const observacionesInput = document.getElementById('prestamoObservaciones');

        if (modal) {
            if (mode === 'add') {
                modalTitle.textContent = 'Agregar Préstamo';
                form.action = '/prestamos/add';
                idInput.value = '';
                idUsuarioInput.value = '';
                idLaboratorioInput.value = '';
                idAdministradorInput.value = '';
                fechaSolicitudInput.value = '';
                fechaPrestamoInput.value = '';
                fechaDevolucionEstimadaInput.value = '';
                estadoInput.value = 'Pendiente';
                observacionesInput.value = '';
            } else if (mode === 'edit') {
                modalTitle.textContent = 'Editar Préstamo';
                form.action = '/prestamos/update';
                idInput.value = id || '';
                idUsuarioInput.value = idUsuario || '';
                idLaboratorioInput.value = idLaboratorio || '';
                idAdministradorInput.value = idAdministrador || '';
                fechaSolicitudInput.value = fechaSolicitud || '';
                fechaPrestamoInput.value = fechaPrestamo || '';
                fechaDevolucionEstimadaInput.value = fechaDevolucionEstimada || '';
                estadoInput.value = estado || 'Pendiente';
                observacionesInput.value = observaciones || '';
            }
            modal.style.display = 'flex';
        }
    }

    // Función para abrir el modal de equipos
    function openEquipoModal(mode, id = null, nombre = '', marca = '', modelo = '', nroSerie = '', nroActivoFijo = '', categoria = '', descripcion = '', cantidad = '', estado = '', idLaboratorio = '') {
        const modal = document.getElementById('equipoModal');
        const form = document.getElementById('equipoForm');
        const modalTitle = document.getElementById('equipoModalTitle');
        const idInput = document.getElementById('equipoId');
        const nombreInput = document.getElementById('equipoNombre');
        const marcaInput = document.getElementById('equipoMarca');
        const modeloInput = document.getElementById('equipoModelo');
        const nroSerieInput = document.getElementById('equipoNroSerie');
        const nroActivoFijoInput = document.getElementById('equipoNroActivoFijo');
        const categoriaInput = document.getElementById('equipoCategoria');
        const descripcionInput = document.getElementById('equipoDescripcion');
        const cantidadInput = document.getElementById('equipoCantidad');
        const estadoInput = document.getElementById('equipoEstado');
        const idLaboratorioInput = document.getElementById('equipoIdLaboratorio');

        if (modal) {
            if (mode === 'add') {
                modalTitle.textContent = 'Agregar Equipo';
                form.action = '/equipos/add';
                idInput.value = '';
                nombreInput.value = '';
                marcaInput.value = '';
                modeloInput.value = '';
                nroSerieInput.value = '';
                nroActivoFijoInput.value = '';
                categoriaInput.value = '';
                descripcionInput.value = '';
                cantidadInput.value = '1';
                estadoInput.value = 'Disponible';
                idLaboratorioInput.value = '';
            } else if (mode === 'edit') {
                modalTitle.textContent = 'Editar Equipo';
                form.action = '/equipos/update';
                idInput.value = id || '';
                nombreInput.value = nombre || '';
                marcaInput.value = marca || '';
                modeloInput.value = modelo || '';
                nroSerieInput.value = nroSerie || '';
                nroActivoFijoInput.value = nroActivoFijo || '';
                categoriaInput.value = categoria || '';
                descripcionInput.value = descripcion || '';
                cantidadInput.value = cantidad || '1';
                estadoInput.value = estado || 'Disponible';
                idLaboratorioInput.value = idLaboratorio || '';
            }
            modal.style.display = 'flex';
        }
    }

    // Función para abrir el modal de mantenimientos
    function openMantenimientoModal(mode, id = null, idEquipo = '', idUsuario = '', fechaInicio = '', fechaFin = '', tipoMantenimiento = '', estadoInicial = '', estadoFinal = '', problema = '', solucion = '', estado = '') {
        const modal = document.getElementById('mantenimientoModal');
        const form = document.getElementById('mantenimientoForm');
        const modalTitle = document.getElementById('mantenimientoModalTitle');
        const idInput = document.getElementById('mantenimientoId');
        const idEquipoInput = document.getElementById('mantenimientoIdEquipo');
        const idUsuarioInput = document.getElementById('mantenimientoIdUsuario');
        const fechaInicioInput = document.getElementById('mantenimientoFechaInicio');
        const fechaFinInput = document.getElementById('mantenimientoFechaFin');
        const tipoMantenimientoInput = document.getElementById('mantenimientoTipoMantenimiento');
        const estadoInicialInput = document.getElementById('mantenimientoEstadoInicial');
        const estadoFinalInput = document.getElementById('mantenimientoEstadoFinal');
        const problemaInput = document.getElementById('mantenimientoProblema');
        const solucionInput = document.getElementById('mantenimientoSolucion');
        const estadoInput = document.getElementById('mantenimientoEstado');

        if (modal) {
            if (mode === 'add') {
                modalTitle.textContent = 'Agregar Mantenimiento';
                form.action = '/mantenimientos/add';
                idInput.value = '';
                idEquipoInput.value = '';
                idUsuarioInput.value = '';
                fechaInicioInput.value = '';
                fechaFinInput.value = '';
                tipoMantenimientoInput.value = '';
                estadoInicialInput.value = '';
                estadoFinalInput.value = '';
                problemaInput.value = '';
                solucionInput.value = '';
                estadoInput.value = 'Pendiente';
            } else if (mode === 'edit') {
                modalTitle.textContent = 'Editar Mantenimiento';
                form.action = '/mantenimientos/update';
                idInput.value = id || '';
                idEquipoInput.value = idEquipo || '';
                idUsuarioInput.value = idUsuario || '';
                fechaInicioInput.value = fechaInicio || '';
                fechaFinInput.value = fechaFin || '';
                tipoMantenimientoInput.value = tipoMantenimiento || '';
                estadoInicialInput.value = estadoInicial || '';
                estadoFinalInput.value = estadoFinal || '';
                problemaInput.value = problema || '';
                solucionInput.value = solucion || '';
                estadoInput.value = estado || 'Pendiente';
            }
            modal.style.display = 'flex';
        }
    }

    // Función para abrir el modal de sanciones
    function openSancionModal(mode, id = null, idUsuario = '', fechaInicio = '', fechaFin = '', estado = '', descripcion = '') {
        const modal = document.getElementById('sancionModal');
        const form = document.getElementById('sancionForm');
        const modalTitle = document.getElementById('sancionModalTitle');
        const idInput = document.getElementById('sancionId');
        const idUsuarioInput = document.getElementById('sancionIdUsuario');
        const fechaInicioInput = document.getElementById('sancionFechaInicio');
        const fechaFinInput = document.getElementById('sancionFechaFin');
        const estadoInput = document.getElementById('sancionEstado');
        const descripcionInput = document.getElementById('sancionDescripcion');

        if (modal) {
            if (mode === 'add') {
                modalTitle.textContent = 'Agregar Sanción';
                form.action = '/sanciones/add';
                idInput.value = '';
                idUsuarioInput.value = '';
                fechaInicioInput.value = '';
                fechaFinInput.value = '';
                estadoInput.value = 'Activa';
                descripcionInput.value = '';
            } else if (mode === 'edit') {
                modalTitle.textContent = 'Editar Sanción';
                form.action = '/sanciones/update';
                idInput.value = id || '';
                idUsuarioInput.value = idUsuario || '';
                fechaInicioInput.value = fechaInicio || '';
                fechaFinInput.value = fechaFin || '';
                estadoInput.value = estado || 'Activa';
                descripcionInput.value = descripcion || '';
            }
            modal.style.display = 'flex';
        }
    }

    // Función para cerrar cualquier modal
    function closeModal(modalId) {
        const modal = document.getElementById(modalId);
        if (modal) {
            modal.style.display = 'none';
        }
    }

    // Asigna eventos a los botones de agregar
    const addPersonaBtn = document.querySelector('.add-persona-btn');
    if (addPersonaBtn) {
        addPersonaBtn.addEventListener('click', () => openPersonaModal('add'));
    }

    const addPrestamoBtn = document.querySelector('.add-prestamo-btn');
    if (addPrestamoBtn) {
        addPrestamoBtn.addEventListener('click', () => openPrestamoModal('add'));
    }

    const addEquipoBtn = document.querySelector('.add-equipo-btn');
    if (addEquipoBtn) {
        addEquipoBtn.addEventListener('click', () => openEquipoModal('add'));
    }

    const addMantenimientoBtn = document.querySelector('.add-mantenimiento-btn');
    if (addMantenimientoBtn) {
        addMantenimientoBtn.addEventListener('click', () => openMantenimientoModal('add'));
    }

    const addSancionBtn = document.querySelector('.add-sancion-btn');
    if (addSancionBtn) {
        addSancionBtn.addEventListener('click', () => openSancionModal('add'));
    }

    // Asigna eventos a los botones de editar
    document.querySelectorAll('#usuarios .edit-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const ru = btn.getAttribute('data-ru');
            const nombre = btn.getAttribute('data-nombre');
            const apellidoPaterno = btn.getAttribute('data-apellidoPaterno');
            const apellidoMaterno = btn.getAttribute('data-apellidoMaterno');
            const correo = btn.getAttribute('data-correo');
            const telefono = btn.getAttribute('data-telefono');
            const fechaNacimiento = btn.getAttribute('data-fechaNacimiento');
            openPersonaModal('edit', ru, nombre, apellidoPaterno, apellidoMaterno, correo, telefono, fechaNacimiento);
        });
    });

    document.querySelectorAll('#prestamos .edit-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.getAttribute('data-id');
            const idUsuario = btn.getAttribute('data-idUsuario');
            const idLaboratorio = btn.getAttribute('data-idLaboratorio');
            const idAdministrador = btn.getAttribute('data-idAdministrador');
            const fechaSolicitud = btn.getAttribute('data-fechaSolicitud');
            const fechaPrestamo = btn.getAttribute('data-fechaPrestamo');
            const fechaDevolucionEstimada = btn.getAttribute('data-fechaDevolucionEstimada');
            const estado = btn.getAttribute('data-estado');
            const observaciones = btn.getAttribute('data-observaciones');
            openPrestamoModal('edit', id, idUsuario, idLaboratorio, idAdministrador, fechaSolicitud, fechaPrestamo, fechaDevolucionEstimada, estado, observaciones);
        });
    });

    document.querySelectorAll('#equipos .edit-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.getAttribute('data-id');
            const nombre = btn.getAttribute('data-nombre');
            const marca = btn.getAttribute('data-marca');
            const modelo = btn.getAttribute('data-modelo');
            const nroSerie = btn.getAttribute('data-nroSerie');
            const nroActivoFijo = btn.getAttribute('data-nroActivoFijo');
            const categoria = btn.getAttribute('data-categoria');
            const descripcion = btn.getAttribute('data-descripcion');
            const cantidad = btn.getAttribute('data-cantidad');
            const estado = btn.getAttribute('data-estado');
            const idLaboratorio = btn.getAttribute('data-idLaboratorio');
            openEquipoModal('edit', id, nombre, marca, modelo, nroSerie, nroActivoFijo, categoria, descripcion, cantidad, estado, idLaboratorio);
        });
    });

    document.querySelectorAll('#mantenimiento .edit-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.getAttribute('data-id');
            const idEquipo = btn.getAttribute('data-idEquipo');
            const idUsuario = btn.getAttribute('data-idUsuario');
            const fechaInicio = btn.getAttribute('data-fechaInicio');
            const fechaFin = btn.getAttribute('data-fechaFin');
            const tipoMantenimiento = btn.getAttribute('data-tipoMantenimiento');
            const estadoInicial = btn.getAttribute('data-estadoInicial');
            const estadoFinal = btn.getAttribute('data-estadoFinal');
            const problema = btn.getAttribute('data-problema');
            const solucion = btn.getAttribute('data-solucion');
            const estado = btn.getAttribute('data-estado');
            openMantenimientoModal('edit', id, idEquipo, idUsuario, fechaInicio, fechaFin, tipoMantenimiento, estadoInicial, estadoFinal, problema, solucion, estado);
        });
    });

    document.querySelectorAll('#sanciones .edit-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.getAttribute('data-id');
            const idUsuario = btn.getAttribute('data-idUsuario');
            const fechaInicio = btn.getAttribute('data-fechaInicio');
            const fechaFin = btn.getAttribute('data-fechaFin');
            const estado = btn.getAttribute('data-estado');
            const descripcion = btn.getAttribute('data-descripcion');
            openSancionModal('edit', id, idUsuario, fechaInicio, fechaFin, estado, descripcion);
        });
    });

    // Cierra los modales al hacer clic fuera
    document.addEventListener('click', (event) => {
        const modals = [
            'personaModal',
            'prestamoModal',
            'equipoModal',
            'mantenimientoModal',
            'sancionModal'
        ];
        modals.forEach(modalId => {
            const modal = document.getElementById(modalId);
            if (modal && event.target === modal) {
                modal.style.display = 'none';
            }
        });
    });

    // Asigna eventos a los botones de cerrar modal
    document.querySelectorAll('.close-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const modal = btn.closest('.modal');
            if (modal) {
                modal.style.display = 'none';
            }
        });
    });
});