package arreglos;

import clases.Alumno;
import java.io.*;
import java.util.ArrayList;


public class GestorAlumnos {


    private String archivo = "alumnos.txt";



    // =====================================
    // AGREGAR ALUMNO
    // =====================================

    public void agregarAlumno(Alumno alumno){


        try{


            FileWriter fw = new FileWriter(archivo,true);

            BufferedWriter bw = new BufferedWriter(fw);



            bw.write(alumno.toLineaArchivo());

            bw.newLine();



            bw.close();



        }catch(IOException e){


            System.out.println(
                    "Error al guardar alumno: "
                    + e.getMessage()
            );


        }


    }





    // =====================================
    // LISTAR ALUMNOS
    // =====================================

    public ArrayList<Alumno> listarAlumnos(){


        ArrayList<Alumno> alumnos = new ArrayList<>();



        try{


            FileReader fr = new FileReader(archivo);

            BufferedReader br = new BufferedReader(fr);



            String linea;



            while((linea = br.readLine()) != null){


                String datos[] = linea.split(",");



                Alumno alumno = new Alumno(

                        Integer.parseInt(datos[0]),

                        datos[1],

                        datos[2],

                        datos[3],

                        Integer.parseInt(datos[4]),

                        Integer.parseInt(datos[5]),

                        Integer.parseInt(datos[6])

                );



                alumnos.add(alumno);


            }



            br.close();



        }catch(IOException e){


            System.out.println(
                    "Error al leer alumnos: "
                    + e.getMessage()
            );


        }



        return alumnos;


    }






    // =====================================
    // BUSCAR ALUMNO POR CODIGO
    // =====================================

    public Alumno buscarAlumno(int codAlumno){



        ArrayList<Alumno> alumnos = listarAlumnos();



        for(Alumno a : alumnos){


            if(a.getCodAlumno() == codAlumno){


                return a;


            }


        }



        return null;


    }








    // =====================================
    // ELIMINAR ALUMNO
    // =====================================

    public boolean eliminarAlumno(int codAlumno){



        ArrayList<Alumno> alumnos = listarAlumnos();



        boolean eliminado = false;



        for(Alumno a : alumnos){


            if(a.getCodAlumno() == codAlumno){


                alumnos.remove(a);

                eliminado = true;

                break;


            }


        }



        if(eliminado){


            guardarTodos(alumnos);


        }



        return eliminado;


    }







    // =====================================
    // MODIFICAR ALUMNO
    // =====================================

    public boolean modificarAlumno(Alumno alumnoNuevo){



        ArrayList<Alumno> alumnos = listarAlumnos();



        boolean encontrado = false;



        for(int i = 0; i < alumnos.size(); i++){



            if(alumnos.get(i).getCodAlumno()
                    == alumnoNuevo.getCodAlumno()){

                alumnos.set(i, alumnoNuevo);
                encontrado = true;
                break;
            }
        }
        if(encontrado){
            guardarTodos(alumnos);
        }
        return encontrado;

    }
    // =====================================
    // GUARDAR TODOS LOS ALUMNOS
    // (Actualiza archivo)
    // =====================================


    private void guardarTodos(ArrayList<Alumno> alumnos){



        try{


            FileWriter fw = new FileWriter(archivo);


            BufferedWriter bw = new BufferedWriter(fw);



            for(Alumno a : alumnos){


                bw.write(
                        a.toLineaArchivo()
                );


                bw.newLine();


            }



            bw.close();



        }catch(IOException e){



            System.out.println(
                    "Error actualizando archivo"
            );


        }


    }



}