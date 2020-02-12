'use strict'
angular.module('alumnoModule', [])
    .controller('AlumnoController', function($scope, $http, $window){

        $scope.alumno = {
            id : null,
            amaterno : null,
            apaterno : null,
            matricula :null,
            nombre : null,

        };

        $scope.alumnos = [];

        // Función para obtener un listado de todos los customers
        function listAlumno(){
            $http.get('/alumno/list').then(
                (response) => {

                    $scope.alumnos = response.data;

                },
                (response) => {

                });

        }

        $scope.add = (alumno) => {

            $http.post('/alumno/save', alumno).then(
                (response) => {

                    listAlumno();

                },
                (response) => {

                    $window.alert(response.status);
                    $window.alert($scope.alumno.nombre);

                }
            );

        }

          $scope.miFormulario = {};
          $scope.funcionRecogeFormulario = function() {

                var datosFormulario = $scope.miFormulario;

                var nombre = datosFormulario.nombre;

                $http.post(
                  '/alumno/save', datosFormulario
                )
                .success(function(data){
                  $window.alert(nombre);
                })
                .error(function(data){
                  alert('Se ha producido un error')
                });
          }

        $scope.delete = (alumno) => {

            const conf = $window.confirm('Está seguro de eleminar esta mono?' + alumno.nombre);

            if(conf){

                $http.delete('/alumno/delete/' + alumno.id, alumno).then((response) => {

                    listAlumno();

                });


            }

        };

        listAlumno();



    });