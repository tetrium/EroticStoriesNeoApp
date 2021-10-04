<?php

namespace vanci_core\entities;

use vanci_core\libs\Globals;
use vanci_core\libs\Common;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversationSentenceLanguageTranslation.sql

 */

class ConversationSentenceLanguageTranslationData
{


     /**
      * @var int
      */
     public $conversationSentenceLanguageTranslationId;


     /**
      * @var string
      */
     public $conversationSentenceId;
     /**
      * @var string
      */
     public $languageId;
     /**
      * @var string
      */
     public $conversationSentenceRawContent;


      /**
      * @var ConversationSentenceElementData[]
      */
      public $conversationSentenceFormattedContent;

     /**
      * @var LanguageData
      */
     public $language;
     public static function getInstance($object): ConversationSentenceLanguageTranslationData
     {

          
          if ($object != null)
               $object = Common::stdClassToClass($object, "vanci_core\\entities\\ConversationSentenceLanguageTranslationData");
          else
               $object = new ConversationSentenceLanguageTranslationData();
          return $object;
     }
     function __construct()
     {
     }
}
