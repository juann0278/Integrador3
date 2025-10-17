<h1>ENDPOINTS</h1>

<h3>a) dar de alta un estudiante</h3>
<p>POST http://localhost:8080/api/estudiantes</p>

<h3>b) matricular un estudiante en una carrera</h3>
<p>POST http://localhost:8080/api/inscripciones/matricular</p>

<h3>c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
</h3>
<p>GET http://localhost:8080/api/estudiantes</p>

<h3>d) recuperar un estudiante, en base a su número de libreta universitaria.
</h3>
<p>GET http://localhost:8080/api/estudiantes/{nroLibreta}</p>

<h3>e) recuperar todos los estudiantes, en base a su género.</h3>
<p>GET http://localhost:8080/api/estudiantes/genero/{genero}</p>

<h3>f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.</h3>
<p>GET http://localhost:8080/api/carreras/inscriptos</p>

<h3>g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.</h3>
<p>GET http://localhost:8080/api/estudiantes/filtrar?id_carrera=id&ciudad=ciudad</p>

<h3>h) generar un reporte de las carreras, que para cada carrera incluya información de los
inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
presentar los años de manera cronológica.</h3>
<p>GET http://localhost:8080/api/carreras/reporte</p>
