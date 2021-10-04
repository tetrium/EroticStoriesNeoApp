<?php

namespace vanci_core\entities;

use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_tag.sql

 */

class ConversationTagData
{


    /**
     * @var int
     */
    public $conversationTagId;

    /**
     * @var int
     */
    public $tagId;
    /**
     * @var string
     */
    public $tagName;
    /**
     * @var int
     */
    public $conversationId;


    function __construct()
    {
        $this->conversationTagId = -1;
        $this->tagId = -1;
        $this->conversationId = -1;

    }
}
