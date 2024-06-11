"""
From project dir:
python ./scripts/create_solution.py problem_name
"""

import os
import sys

WORKING_DIR = os.path.join(os.getcwd(), 'src', 'solutions')
TEMPLATE_DIR = os.path.join(os.getcwd(), 'scripts', 'templates')
INPUT_OUTPUT_TEMPLATE_FILE_DIR = os.path.join(TEMPLATE_DIR, 'InputOutputTemplate.kt')

link_name = sys.argv[1]
name = link_name.split("-")
dir_name = ''.join(name)
dir_path_name = os.path.join(WORKING_DIR, dir_name)
fun_name = ''.join([name[0]] + [word.title() for word in name[1:]])
file_name = ''.join([word.title() for word in name])
file_dir = os.path.join(dir_path_name, f"{file_name}.kt")

with open(INPUT_OUTPUT_TEMPLATE_FILE_DIR, 'r') as input:
    text = input.read().replace('{FUN_NAME}',
                                fun_name).replace('{DIR_NAME}',
                                                  dir_name).replace('{LINK_NAME}',
                                                                    link_name)

os.mkdir(dir_path_name)
with open(file_dir, 'w') as output:
    output.write(text)

print(WORKING_DIR)
print(os.getcwd())
