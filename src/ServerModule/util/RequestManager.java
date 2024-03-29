package ServerModule.util;

import common.util.Request;
import common.util.Response;
import common.util.ResponseCode;

public class RequestManager {
    private CommandManager commandManager;

    public RequestManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public Response manage(Request request) {
        ResponseCode responseCode = executeCommand(request.getCommandName(), request.getArgument(), request.getObjectArgument());
        return new Response(responseCode, ResponseOutputer.getAndClear());
    }

    private ResponseCode executeCommand(String command, String argument, Object objectArgument) {
        switch (command) {
            case "":
                break;
            case "loadCollection":
                if (!commandManager.loadCollection(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "help":
                if (!commandManager.help(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "info":
                if (!commandManager.info(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "show":
                if (!commandManager.show(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "insert":
                if (!commandManager.insert(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "update":
                if (!commandManager.update(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "remove_key":
                if (!commandManager.removeKey(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "clear":
                if (!commandManager.clear(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "execute_script":
                if (!commandManager.executeScript(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "exit":
                if (!commandManager.exit(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "remove_lower":
                if (!commandManager.removeLower(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "remove_greater_key":
                if (!commandManager.removeGreaterKey(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "filter_by_transport":
                if (!commandManager.filterByTransport(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "filter_less_than_new":
                if (!commandManager.filterLessThanNew(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "print_field_ascending_height":
                if (!commandManager.printFieldAscendingHeight(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            case "save":
                if (!commandManager.save(argument, objectArgument)) return ResponseCode.ERROR;
                break;
            default:
                ResponseOutputer.append("Команда '" + command + "' не найдена. Наберите 'help' для справки.\n");
                return ResponseCode.ERROR;
        }
        return ResponseCode.OK;
    }
}
