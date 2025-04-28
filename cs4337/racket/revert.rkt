#lang racket

(define revert (lambda (a) (
                            cond
                              [(null? a) a]
                              [(null? (rest a)) a]
                              [(append (revert (cdr a)) (list (car a)))]
                              )
                 )
  )

(revert '(a b c d e))