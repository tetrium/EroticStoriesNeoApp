<?php

namespace vanci_core\entities;

use vanci_core\libs\CatalogError;
use vanci_core\libs\Common;

class WebApiErrorData
{
     /**
      * @var int
      */
     public $errorId = -1;  //:int
     // public $errorKeyWord = ""; // :string
     /**
      * @var string
      */
     public $errorDescription = ""; //:string 
     /**
      * @var string
      */
      public $errorDetails = ""; //:string 

     function __construct(int $errorId = null,string $errorDetails='')
     {
          $this->errorId = $errorId;
          $this->errorDetails=$errorDetails;
          $catalogError = CatalogError::getInstance();
          $this->errorDescription = $catalogError->getErrorDescription($errorId);

         
     }

     public static function getInstance($object): WebApiErrorData
     {

          if ($object != null)
               $object = Common::stdClassToClass($object, "vanci_core\\entities\\WebApiErrorData");
          else
               $object = new ConversationData(-1);
          return $object;
     }

}
