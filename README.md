# AND-CicloVidaActivity
Ejemplo del ciclo de vida de una activity
Sobreescritos los métodos callback que son llamados durante la transición de estados del ciclo de vida de la activity para que logen información del instante en que es llamado cada uno de ellos.

Sobrescritos métodos onSavaInstanceState y onRestoreInstanceState para que graben y resaturen respectivamente el valor del contador de la app. Estos métodos son llamados antes de que se destruya la activity, cuando: 
    - se rota el dispositivo, nos vamos a la pantalla princial.
    - se abre otra app sin haber cerrado esta con el botón back.
    - nos vamos a la pantalla del launcher pulsando la home.

También se han implementado (pero están comentados) mecanismo de persistencia en los métodos onPause() y onStart(), usando objeto Sharepreferences. Este mecanismo graba y restaura el valor del contador en todos los casos anteriores y además cuando salimos de la actividad pulsando back, o el sistema la destruye mientras esta en estado pausada o parada para recuperar recursos de memoria.
Para activar este mecanismo descomentar código y comentar los métodos onSavaInstanceState y onRestoreInstanceState.
