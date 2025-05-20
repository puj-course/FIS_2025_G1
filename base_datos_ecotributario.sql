
- Script para SQLite

-- Tabla de Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    rol TEXT CHECK(rol IN ('admin', 'empresa')) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Empresas
CREATE TABLE IF NOT EXISTS Empresas (
    id_empresa INTEGER PRIMARY KEY AUTOINCREMENT,
    id_usuario INTEGER NOT NULL,
    nombre_empresa TEXT NOT NULL,
    nit TEXT UNIQUE NOT NULL,
    direccion TEXT,
    telefono TEXT,
    sector TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE
);

-- Tabla de Incentivos
CREATE TABLE IF NOT EXISTS Incentivos (
    id_incentivo INTEGER PRIMARY KEY AUTOINCREMENT,
    id_empresa INTEGER NOT NULL,
    tipo_incentivo TEXT CHECK(tipo_incentivo IN ('reciclaje', 'energía_renovable', 'otros')) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    descripcion TEXT,
    fecha_aplicacion DATE NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES Empresas(id_empresa) ON DELETE CASCADE
);

-- Tabla de Reportes
CREATE TABLE IF NOT EXISTS Reportes (
    id_reporte INTEGER PRIMARY KEY AUTOINCREMENT,
    id_incentivo INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    detalle TEXT,
    FOREIGN KEY (id_incentivo) REFERENCES Incentivos(id_incentivo) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE
);


-- Datos de prueba
INSERT INTO Usuarios (nombre, email, password, rol) VALUES ('Sarix', 'sarix@ejemplo.com', '1234', 'admin');
