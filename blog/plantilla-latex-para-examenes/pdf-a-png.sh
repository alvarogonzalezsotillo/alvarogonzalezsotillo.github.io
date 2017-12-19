#!/bin/bash
rm cuadro*.png
rm preguntas*.png

convert ejemplo.pdf -transparent white -alpha remove -resize x500 ejemplo.png
mv ejemplo-0.png cuadro-respuestas.png
mv ejemplo-5.png preguntas-abiertas.png
mv ejemplo-1.png preguntas-cerradas.png 

convert ejemplo.pdf -transparent white -alpha remove -resize x1500 ejemplo.png
mv ejemplo-0.png cuadro-respuestas-grande.png
mv ejemplo-5.png preguntas-abiertas-grande.png
mv ejemplo-1.png preguntas-cerradas-grande.png

rm ejemplo*.png
