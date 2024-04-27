@echo off


SET IMAGEN=
echo Los ficheros a firmar son %*

:FIRMASIGUIENTE

if "%~1"=="" (
    echo No quedan más ficheros que firmar
    goto :end
)

set DNI=1234
set ARCHIVO=%~dpF1
set ARCHIVOSINEXTENSION=%~dpn1

echo Se va a firmar el archivo %ARCHIVO%

SET PositionOnPageLowerLeftX=50  
SET PositionOnPageLowerLeftY=135   
SET PositionOnPageUpperRightX=250 
SET PositionOnPageUpperRightY=245 
SET l2FontColor=black             
SET l2FontSize=7                  
SET l2FontFamily=1                
SET l2FontStyle=0                 
SET LAYER2TEXT=Firmado por $$GIVENNAME$$ $$SURNAME$$ el $$SIGNDATE=dd/MM/YYYY$$ con un certificado emitido por $$ISSUERCN$$ con n£mero de serie $$CERTSERIAL$$


SET signaturePage=1               
SET CONFIG=headless=true\n layer2Text=%LAYER2TEXT%\n    signaturePositionOnPageLowerLeftX=%PositionOnPageLowerLeftX%\n    signaturePositionOnPageLowerLeftY=%PositionOnPageLowerLeftY%\n    signaturePositionOnPageUpperRightX=%PositionOnPageUpperRightX%\n    signaturePositionOnPageUpperRightY=%PositionOnPageUpperRightY%\n    layer2FontColor=%l2FontColor%\n    layer2FontSize=%l2FontSize%\n    layer2FontFamily=%l2FontFamily%\n    layer2FontStyle=%l2FontStyle%\n       signaturePage=%signaturePage% \n signatureRubricImage=%IMAGEN%

echo   Primera firma en p gina 1
autofirmacommandline sign -i "%ARCHIVO%" -o "%ARCHIVOSINEXTENSION% - firmado.pdf" -config "%CONFIG%" -filter subject.contains:%DNI%;nonexpired:

shift
goto :FIRMASIGUIENTE


:end
