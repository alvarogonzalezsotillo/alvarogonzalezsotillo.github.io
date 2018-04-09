(TeX-add-style-hook
 "plantilla-latex-para-examenes"
 (lambda ()
   (TeX-add-to-alist 'LaTeX-provided-class-options
                     '(("article" "8pt" "a4paper" "spanish" "openany")))
   (TeX-add-to-alist 'LaTeX-provided-package-options
                     '(("inputenc" "utf8") ("fontenc" "T1") ("geometry" "top=2.0cm" "left=1.2cm" "right=1.2cm" "bottom=2.0cm" "a4paper") ("babel" "spanish")))
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "path")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "url")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "nolinkurl")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperbaseurl")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperimage")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperref")
   (add-to-list 'LaTeX-verbatim-macros-with-delims-local "path")
   (TeX-run-style-hooks
    "latex2e"
    "article"
    "art10"
    "inputenc"
    "fontenc"
    "enumitem"
    "multicol"
    "setspace"
    "geometry"
    "babel"
    "forloop"
    "attachfile"
    "color"
    "colortbl"
    "graphicx"
    "qrcode"
    "fancyhdr"
    "lastpage"
    "extramarks"
    "ctable"
    "grffile"
    "currfile"
    "fancybox"
    "array")
   (TeX-add-symbols
    '("FirstPage" 5)
    '("AnswerTable" 3)
    '("LetterVerticalAnswerTable" 1)
    '("LetterHorizontalAnswerTable" 1)
    '("TickedHorizontalAnswerTable" 1)
    '("TickedVerticalAnswerTable" 1)
    '("TickedAnswerCellTemplate" 5)
    '("LetterAnswerCellTemplate" 1)
    '("OriginalGiftFile" 1)
    '("FileAutoref" 0)
    '("Instructions" 3)
    '("LetterInstructions" 2)
    '("TickedInstructions" 2)
    '("Answer" 1)
    "Solutions"
    "Width"
    "HalfWidth"
    "Height"
    "HalfHeight"
    "QuarterHeight"
    "HorizontalLine"
    "IndentOn"
    "IndentOff"
    "StudentData"
    "TickWidth"
    "HeaderCell"
    "AnswerCell"
    "newline")
   (LaTeX-add-environments
    '("ShadowBox" LaTeX-env-args ["argument"] 1)
    '("QuestionnaireQuestion" LaTeX-env-args ["argument"] 0)
    "QuestionnaireQuestions"
    "QuarterPageOpenQuestion"
    "HalfPageOpenQuestion"
    "FullPageOpenQuestion")
   (LaTeX-add-counters
    "QuestionCounter"
    "AnswerTableC"
    "DummyAnswerCounter")
   (LaTeX-add-saveboxes
    "fmboxx")
   (LaTeX-add-color-definecolors
    "light-gray"
    "sep-gray")
   (LaTeX-add-array-newcolumntypes
    "x"))
 :latex)

