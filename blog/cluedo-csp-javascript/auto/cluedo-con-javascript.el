(TeX-add-style-hook
 "cluedo-con-javascript"
 (lambda ()
   (TeX-add-to-alist 'LaTeX-provided-class-options
                     '(("article" "11pt")))
   (TeX-add-to-alist 'LaTeX-provided-package-options
                     '(("inputenc" "utf8") ("fontenc" "T1") ("ulem" "normalem")))
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperref")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperimage")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperbaseurl")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "nolinkurl")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "url")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "path")
   (add-to-list 'LaTeX-verbatim-macros-with-delims-local "path")
   (TeX-run-style-hooks
    "latex2e"
    "article"
    "art11"
    "inputenc"
    "fontenc"
    "graphicx"
    "grffile"
    "longtable"
    "wrapfig"
    "rotating"
    "ulem"
    "amsmath"
    "textcomp"
    "amssymb"
    "capt-of"
    "hyperref")
   (LaTeX-add-labels
    "sec:org7425dda"
    "sec:org6cf409c"
    "sec:org7016a35"
    "sec:org34ec55b"
    "sec:orgbce83ed"
    "sec:org82d7426"
    "sec:org9c4e729"
    "sec:org4a69321"
    "sec:orgbc3c64b")
   (LaTeX-add-environments
    '("entradasalidacols" LaTeX-env-args ["argument"] 1)
    '("entradasalida" LaTeX-env-args ["argument"] 1)
    '("cuadrito" LaTeX-env-args ["argument"] 0)
    '("homeworkProblem" LaTeX-env-args ["argument"] 0)))
 :latex)

